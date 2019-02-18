package edu.uark.commands.employees;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeByEmployeeIDQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.employeeID)) {
			throw new UnprocessableEntityException("EmployeeID");
		}
		
		EmployeeEntity productEntity = this.EmployeeRepository.byEmployeeID(this.employeeID);
		if (productEntity != null) {
			return new Employee(productEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}

	//Properties
	private String employeeID;
	public String getEmployeeID() {
		return this.employeeID;
	}
	public EmployeeByEmployeeIDQuery setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
		return this;
	}
	
	private EmployeeRepositoryInterface EmployeeRepository;
	public EmployeeRepositoryInterface setEmployeeRepository() {
		return this.EmployeeRepository;
	}
	public EmployeeByEmployeeIDQuery setEmployeeRepository(EmployeeRepositoryInterface EmployeeRepository) {
		this.EmployeeRepository = EmployeeRepository;
		return this;
	}
	
	public EmployeeByEmployeeIDQuery() {
		this.EmployeeRepository = new EmployeeRepository();
	}
}
