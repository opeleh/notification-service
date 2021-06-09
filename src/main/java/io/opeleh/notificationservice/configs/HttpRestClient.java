package io.opeleh.notificationservice.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
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

@Service
@Slf4j
public class HttpRestClient {

    @Value("${proxy.host}")
    private String hostname;

    @Value("${proxy.port}")
    private int port;



    public RestTemplate restTemplate(){

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname,port));

        requestFactory.setProxy(proxy);

        return new RestTemplate(requestFactory);
    }

}
