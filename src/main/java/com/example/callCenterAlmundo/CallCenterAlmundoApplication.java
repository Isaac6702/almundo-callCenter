package com.example.callCenterAlmundo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.callCenterAlmundo.model.Call;
import com.example.callCenterAlmundo.model.Client;
import com.example.callCenterAlmundo.service.Dispatcher;

@SpringBootApplication
public class CallCenterAlmundoApplication implements CommandLineRunner {

	@Autowired
	private Dispatcher dispatcher;

	public static void main(String[] args) {
		SpringApplication.run(CallCenterAlmundoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		for (int i = 0; i < 20; i++) {
			Client client = new Client("client" + i);
			Call call = new Call(client, 10, 5);
			dispatcher.dispatchCall(call);
		}

	}
}
