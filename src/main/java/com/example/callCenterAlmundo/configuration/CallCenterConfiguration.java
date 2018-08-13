package com.example.callCenterAlmundo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.example.callCenterAlmundo.model.Director;
import com.example.callCenterAlmundo.model.Employee;
import com.example.callCenterAlmundo.model.Operator;
import com.example.callCenterAlmundo.model.Supervisor;

@Configuration
public class CallCenterConfiguration {
	@Value("${callCenter.numberOfConcurrentCalls}")
	private int numberOfConcurrentCalls;
	@Value("${callCenter.queueCapacity}")
	private int queueCapacity;
	@Value("${callCenter.numberOfOperators}")
	private int numberOfOperators;
	@Value("${callCenter.numberOfSupervisor}")
	private int numberOfSupervisor;
	@Value("${callCenter.numberOfDirector}")
	private int numberOfDirector;

	private List<Employee> loadEmployees(String type) {
		List<Employee> employees = new ArrayList<>();
		switch (type) {
		case "operator":
			for (Integer i = 1; i <= numberOfOperators; i++) {
				employees.add(new Operator(i.longValue(), type + i));
			}
			break;
		case "supervisor":
			for (Integer i = 1; i <= numberOfSupervisor; i++) {
				employees.add(new Supervisor(i.longValue(), type + i));
			}
			break;
		case "director":
			for (Integer i = 1; i <= numberOfDirector; i++) {
				employees.add(new Director(i.longValue(), type + i));
			}
			break;
		default:
			int size = 5;
			for (Integer i = 1; i <= size; i++) {
				employees.add(new Employee(i.longValue(), type + i));
			}
			break;
		}


		return employees;
	}

	@Bean
	public List<Employee> loadEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.addAll(loadEmployees("operator"));
		employees.addAll(loadEmployees("supervisor"));
		employees.addAll(loadEmployees("director"));
		return employees;
	}

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(numberOfConcurrentCalls);
		executor.setMaxPoolSize(numberOfConcurrentCalls);
		executor.setQueueCapacity(queueCapacity);
		return executor;
	}
}
