package mavenMap.MapImplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class EmployeeRepository {
	public final Logger employeeResourceLogger = Logger.getLogger(EmployeeResource.class);
	private static EmployeeRepository employeeInstance = null;
	private static HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	static int i = 10;

	public void setI(int in) {
		i = in;
	}
	public HashMap<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}
	public EmployeeRepository() {
	}

	public boolean isEmployee(int id) {
		return employeeMap.containsKey(id);
	}

	public static EmployeeRepository getInstance() {
		if (employeeInstance == null)
			return new EmployeeRepository();
		return employeeInstance;
	}

	public ArrayList<Employee> getEmployees() {
		Collection<Employee> values = getEmployeeMap().values();
		ArrayList<Employee> listOfValues = new ArrayList<Employee>(values);
		System.out.println("get Employees");
		return listOfValues;
	}

	public Object getEmployee(Integer id) {
		if (isEmployee(id) == true) {
			Employee employeeRecord = getEmployeeMap().get(id);
			employeeResourceLogger.info("Displaying employee id : " + id + "detials");
			return employeeRecord;
		}
		System.out.println("get Employee with id = " + id);
		employeeResourceLogger.error("Displaying employee id : " + id + "detials");
		return new ErrorMessage("Record doesnot exist");

	}

	public boolean createEmployee(Employee record) {
		if (getEmployeeMap().get(record.getId()) == null) {
			getEmployeeMap().put(record.getID(), record);
			return true;
		}
		return false;
	}

	public boolean updateEmployee(Employee record) {
		if (isEmployee(record.getID()) == true) {
			getEmployeeMap().replace(record.getID(), record);
			System.out.println("updateEmployee");
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "EmployeeRepository [employeeMap=" + employeeMap + ", i=" + i + "]";
	}

}
