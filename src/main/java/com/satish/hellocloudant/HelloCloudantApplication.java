package com.satish.hellocloudant;

import com.cloudant.client.api.CloudantClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class HelloCloudantApplication {
	@Autowired
	private CloudantClient client;

	public static void main(String[] args) {
		SpringApplication.run(HelloCloudantApplication.class, args);
	}

	@GetMapping("cloudant")
	String Cloudant(){
		List<String> list = new ArrayList<String>();
		try {
			list = client.getAllDbs();
		} catch (NullPointerException ex){
			return "server error";
		}
		System.out.println(list.toString());
		return   list.toString();
	}

}
