package org.onesubhadip.servicerouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ServiceRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRouterApplication.class, args);
	}

}
