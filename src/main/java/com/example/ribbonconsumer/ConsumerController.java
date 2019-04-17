package com.example.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;

    /*@RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }*/

    @RequestMapping(value = "/ribbon-consumer", method= RequestMethod.GET)
    public String helloConsumer () {
        long start = System.currentTimeMillis();
        String result = helloService.helloService();
        long end= System.currentTimeMillis();
        System.out.println("Spend time : "+ (end - start));
        return result;
    }
}
