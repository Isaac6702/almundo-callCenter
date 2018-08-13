package com.example.callCenterAlmundo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.callCenterAlmundo.model.Call;
import com.example.callCenterAlmundo.model.Client;
import com.example.callCenterAlmundo.service.Dispatcher;


public class CallCenterAlmundoApplicationTests  extends ServiceTest{
	@Autowired
	private Dispatcher dispatcher;
	
	@Test
	public void testAllCalls() {
		for (int i = 0; i < 9; i++) {
			Client client = new Client("client" + i);
			Call call = new Call(client, 10, 5);
			dispatcher.dispatchCall(call);
		}
	}

}
