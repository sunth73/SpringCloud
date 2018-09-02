package com.sunth.callBack;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sunth
 * @DateTime 2018-08-30 21:04
 * 描述
 */
@Component
public class CallBackforZuul implements FallbackProvider {
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ClientHttpResponse() {

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK; //请求网关成功了，所以是ok
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                JSONObject json =new JSONObject();
                json.put("state","501");
                json.put("msg","所买影票，已经告罄");
                return new ByteArrayInputStream(json.toJSONString().getBytes("UTF-8")); //返回前端的内容
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); //设置头
                return httpHeaders;
            }
        };
    }

    @Override
    public String getRoute() {
        return "CUSTOMER_HYSTRIX";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {

      return null;
    }
}
