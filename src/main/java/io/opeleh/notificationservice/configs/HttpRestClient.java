package io.opeleh.notificationservice.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

/*
 * Implementation of RestTemplate for http request.
 *
 * @author   Fola Akinbobola
 * @since    2021-06-06
 * @version  1.0.1
 * @company  opelehng.io
 *
 */

@Configuration
@Slf4j
public class HttpRestClient {

    @Value("${proxy.host}")
    private String hostname;

    @Value("${proxy.port}")
    private int port;

    @Bean
    public RestTemplate restTemplate(){

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname,port));

        requestFactory.setProxy(proxy);
        requestFactory.setConnectTimeout(15000);
        requestFactory.setReadTimeout(5000);

        return new RestTemplate(requestFactory);
    }

}
