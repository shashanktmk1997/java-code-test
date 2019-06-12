package tester;

import static org.junit.Assert.assertEquals;
import org.powermock.api.mockito.PowerMockito;
import java.io.File;
import java.util.HashMap;

import org.junit.Test;

import mavenMap.MapImplementation.Employee;
import mavenMap.MapImplementation.EmployeeRepository;
import mavenMap.MapImplementation.ErrorMessage;

public class EmployeeResourceTester {
	
	static HashMap <Integer,Employee> employeeRecords= null;
	EmployeeRepository employeeRepository = EmployeeRepository.getInstance();;
	public void createEmployeeMap()
	{
		employeeRecords = new HashMap <Integer,Employee>();
		employeeRecords.put(1,new Employee(1,"alex"));
		employeeRecords.put(1,new Employee(2,"alen"));
		
	}
	@Test public void createEmployeeTest() {
		Object actual = employeeRepository.createEmployee(new Employee(1, "abc"));
		assertEquals(false, employeeRepository.createEmployee(new Employee(1, "abc")));
	}
	
}


