package com.ziqingwang.eureka;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Ziven
 * @date: 2018/12/06
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServer.class).web(WebApplicationType.SERVLET).run(args);
	}
}
