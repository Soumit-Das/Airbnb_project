package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirbnbApplication {

	public static void main(String[] args) {
		
		
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=- Application is starting -=-=-=-=-=-=-=-=-=-=-=-=-=-");
		SpringApplication.run(AirbnbApplication.class, args);
		System.out.println();
		System.out.println("                                 -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is working fine -=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
	}

}
