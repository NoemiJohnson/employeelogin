package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.EmployeeByEmployeeIDQuery;
import edu.uark.commands.employees.EmployeeCreateCommand;
import edu.uark.commands.employees.EmployeeDeleteCommand;
import edu.uark.commands.employees.EmployeeQuery;
import edu.uark.commands.employees.EmployeeUpdateCommand;
import edu.uark.models.api.Employee;


//Define new or extend existing employee functionality to support an employee login:

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable UUID employeeId) {
		return (new EmployeeQuery()).
			setEmployeeId(employeeId).
			execute();
	}

	@RequestMapping(value = "/byEmployeeID/{EmployeeByEmployeeIDQuery}", method = RequestMethod.GET)
	public Employee getetByLookupCode(@PathVariable String EmployeeByEmployeeIDQuery) {
		return (new EmployeeByEmployeeIDQuery()).
			setEmployeeID(EmployeeByEmployeeIDQuery).
			execute();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return (new EmployeeCreateCommand()).
			setApiEmployee(employee).
			execute();
	}
	
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable UUID employeeId, @RequestBody Employee employee) {
		return (new EmployeeUpdateCommand()).
			setEmployeeId(employeeId).
			setApiEmployee(employee).
			execute();
	}
	
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable UUID employeeId) {
		(new EmployeeDeleteCommand()).
			setEmployeeId(employeeId).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}