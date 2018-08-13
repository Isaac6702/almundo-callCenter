package com.example.callCenterAlmundo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.example.callCenterAlmundo.model.Call;
import com.example.callCenterAlmundo.model.Director;
import com.example.callCenterAlmundo.model.Employee;
import com.example.callCenterAlmundo.model.Operator;
import com.example.callCenterAlmundo.model.Supervisor;

@Service("dispatcher")
public class Dispatcher {

	@Autowired
	private TaskExecutor taskExecutor;
	@Autowired
	@Qualifier("loadEmployees")
	private List<Employee> employees;

	private Employee findEmployeeAvailableByType(Class<?> type) {
		for (Iterator<Employee> iterator = this.employees.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();
			if (employee.getStatus().equals(Employee.Status.AVAILABLE) && employee.getClass().equals(type)) {
				return employee;
			}
		}
		return null;
	}

	private Employee findEmployeeAvailable() {
		Employee operator = findEmployeeAvailableByType(Operator.class);
		if (operator != null) {
			return operator;
		} else {
			Employee supervisor = findEmployeeAvailableByType(Supervisor.class);
			if (supervisor != null) {
				return supervisor;
			} else {
				Employee director = findEmployeeAvailableByType(Director.class);
				if (director != null) {
					return director;
				}
			}
		}
		return null;
	}

	public void dispatchCall(Call call) {
		Employee employeeAvailable = findEmployeeAvailable();
		if (employeeAvailable != null) {
			call.setEmployee(employeeAvailable);
			taskExecutor.execute(call);
		} else {
			System.out.println("[WARNING] no existe empleados para atender la llamda");
		}
	}
}
