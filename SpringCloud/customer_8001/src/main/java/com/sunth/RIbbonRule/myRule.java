package com.sunth.RIbbonRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author Sunth
 * @DateTime 2018-08-27 19:33
 * 描述： 自定义ribbon负载均衡规则
 */
public class myRule extends AbstractLoadBalancerRule {
    int totle=0;
    int currentIndex=0;


    public Server choose(ILoadBalancer lb, Object key) {

        if (lb == null) {

            return null;

        }

        Server server = null;



        while (server == null) {

            if (Thread.interrupted()) {

                return null;

            }

            List<Server> upList = lb.getReachableServers();

            List<Server> allList = lb.getAllServers();



            int serverCount = allList.size();

            if (serverCount == 0) {

                /*

                 * No servers. End regardless of pass, because subsequent passes

                 * only get more restrictive.

                 */

                return null;

            }


//官方随机
//            int index = chooseRandomInt(serverCount);
            //  server = upList.get(index);


            //自定义轮询
//            if(currentIndex<upList.size()){
//            	server=upList.get(currentIndex);
//            	currentIndex++;
//            }else{
//            	currentIndex=0;
//            }
            //每个服务次数递增
            if(currentIndex>=totle){
                server=upList.get(currentIndex);
                totle++;
            }else{
                totle=0;
                currentIndex++;
                if(currentIndex>=upList.size()){
                    currentIndex=0;
                }
            }
//每个服务5次
//            if(totle<5){
//            	server=upList.get(currentIndex);
//            	totle++;
//            }else{
//            	totle=0;
//            	currentIndex++;
//            	if(currentIndex>=upList.size()){
//            		currentIndex=0;
//            	}
//            }

            if (server == null) {

                /*

                 * The only time this should happen is if the server list were

                 * somehow trimmed. This is a transient condition. Retry after

                 * yielding.

                 */

                Thread.yield();

                continue;

            }



            if (server.isAlive()) {

                return (server);

            }



            // Shouldn't actually happen.. but must be transient or a bug.

            server = null;

            Thread.yield();

        }



        return server;



    }



//    protected int chooseRandomInt(int serverCount) {
//
//        return ThreadLocalRandom.current().nextInt(serverCount);
//
//    }



    @Override

    public Server choose(Object key) {

        return choose(getLoadBalancer(), key);

    }



    @Override

    public void initWithNiwsConfig(IClientConfig clientConfig) {

        // TODO Auto-generated method stub



    }
}
