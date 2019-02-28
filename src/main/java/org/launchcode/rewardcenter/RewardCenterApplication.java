package org.launchcode.rewardcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.boot.SpringApplication.*;
import static org.springframework.boot.SpringApplication.run;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


@SpringBootApplication
public class RewardCenterApplication {

	public static void main(String[] args) {
//		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
//		System.out.println(bCryptPasswordEncoder.encode("mana"));
//		System.out.println(bCryptPasswordEncoder.encode("dhanu"));

		run(RewardCenterApplication.class, args);
	}

}

