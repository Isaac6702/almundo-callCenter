package com.example.callCenterAlmundo.model;

public class Employee {
	private Long id;
	private String firstName;
	// private String lastName;
	private Enum<Status> status;

	// public Employee(Long id, String firstName, String lastName) {
	public Employee(Long id, String firstName) {
		this.id = id;
		this.firstName = firstName;
		// this.lastName = lastName;
		this.status = Status.AVAILABLE;
	}

	public static enum Status {
		ONCALL, AVAILABLE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// public String getLastName() {
	// return lastName;
	// }
	//
	// public void setLastName(String lastName) {
	// this.lastName = lastName;
	// }

	public Enum<Status> getStatus() {
		return status;
	}

	public void setStatus(Enum<Status> status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Employee employee = (Employee) object;
		return this.id.equals(employee.getId());
	}

}
