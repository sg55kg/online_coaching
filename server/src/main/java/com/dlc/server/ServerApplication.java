package com.dlc.server;

import com.dlc.server.controller.ExerciseController;
import com.dlc.server.controller.MacroCycleController;
import com.dlc.server.model.Day;
import com.dlc.server.model.Exercise;
import com.dlc.server.model.MacroCycle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner test(MacroCycleController controller) {
//		return args -> {
//			var mc = new MacroCycle(new Date(2022,3,20), 300);
//
//			String res = controller.add(mc);
//			System.out.println(res);
//		};
//	}

}
