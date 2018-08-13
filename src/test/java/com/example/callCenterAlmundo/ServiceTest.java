package com.example.callCenterAlmundo;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.callCenterAlmundo.configuration.CallCenterConfiguration;
import com.example.callCenterAlmundo.configuration.PropertyConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Ignore
public class ServiceTest {

	@Configuration
	@ComponentScan(
			basePackages = { 
					"com.example.callCenterAlmundo.service"
			},
			basePackageClasses = {
					PropertyConfig.class,
					CallCenterConfiguration.class
			}			
	)
	public static class Config {
	
	}

}
