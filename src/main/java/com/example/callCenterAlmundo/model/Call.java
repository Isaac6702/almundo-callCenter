package com.example.callCenterAlmundo.model;

import java.util.Random;

public class Call implements Runnable {

	private Client client;
	private int duration;
	private Employee employee;

	public Call(Client client, int maxDuration, int minDuration) {
		Random random = new Random();
		this.client = client;
		this.duration = (random.nextInt(maxDuration - minDuration) + minDuration) * 1000;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		employee.setStatus(Employee.Status.ONCALL);
		this.employee = employee;
	}
	
	public Client getClient() {
		return client;
	}

	@Override
	public void run() {
		System.out.println("[INFO] Inicio llamada con el empleado " + this.employee.getFirstName() + " con una duracion de "
				+ this.duration);
		try {
			Thread.sleep(9000);
			this.employee.setStatus(Employee.Status.AVAILABLE);
			System.out.println("[INFO] Finalizo llamada del empleado " + this.employee.getFirstName());
		} catch (InterruptedException e) {
			System.out.println("[ERROR] Hilo interrupido");
		}
	}

}
