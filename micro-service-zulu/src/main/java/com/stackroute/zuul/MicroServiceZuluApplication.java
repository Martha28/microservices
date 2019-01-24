package com.stackroute.zuul;

import com.stackroute.zuul.filters.ErrorFilter;
import com.stackroute.zuul.filters.PostFilter;
import com.stackroute.zuul.filters.PreFilter;
import com.stackroute.zuul.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceZuluApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceZuluApplication.class, args);
	}
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}

