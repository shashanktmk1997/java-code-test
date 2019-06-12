package mavenMap.MapImplementation;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("restservice")
public class EmployeeResource {
		EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
		public final Logger employeeResourceLogger = Logger.getLogger(EmployeeResource.class);
		
	@GET
	@Path("employees")	
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public ArrayList<Employee> getEmployees()
	{
		employeeResourceLogger.info("Displayed all the avaliable employees");
		return employeeRepository.getEmployees();
	}
	
	@GET
	@Path("employee/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Object getEmployee(@PathParam("id") int id)
	{
		//return new Employee();
		return employeeRepository.getEmployee(new Integer(id));
	}
	
	@POST
	@Path("create")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Object createEmployee(Employee record)
	{
		System.out.println("id : "+ record.getId()+"    name : "+record.getName());
		if(record.getId()==0||record.getName().equalsIgnoreCase("null")) {
			employeeResourceLogger.error("Either ID or Name are not specified in body");
			return new ErrorMessage("Values are not specified ");
		}
		if(employeeRepository.isEmployee(record.getId())==false)
			if(employeeRepository.createEmployee(record) == true)
			{
				employeeResourceLogger.info("Created employee with id : "+record.getId());
				return record;
			}
			employeeResourceLogger.error("Trying to recreate existing employee");
			return new ErrorMessage("Specified user id already exists ");
		
	}
	@PUT
	@Path("update/{id}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Object updateEmployee(Employee record,@PathParam("id")int urlId)
	{
		
		System.out.println("id : "+ record.getId()+"    name : "+record.getName());
		if(urlId==0) {
			employeeResourceLogger.error("Id is not specified in url for update");
			return new ErrorMessage("ID is not specified in URL ");
		}
		if(record.getId()!=0) {
			employeeResourceLogger.error("ID is again specifed in body for update");
			return new ErrorMessage("ID is again specified in xml body");
		}
		record.setId(urlId);
		if(employeeRepository.isEmployee(record.getId())==true)
			if(employeeRepository.updateEmployee(record) == true) {
				employeeResourceLogger.info("Updated employee with id : "+record.getId());
				return record;
			}
		employeeResourceLogger.error("Update service requested for non existing user with id : "+urlId);
		return new ErrorMessage("Specified user id does not exists");
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		EmployeeRepository e = EmployeeRepository.getInstance();
//		
//		System.out.println(e.toString());
//		e.setI(33);
//		System.out.println(e.toString());
//	System.out.println("--------------------------------");
//	if(e.createEmployee(new Employee())==true)
//		System.out.println(e.toString());
//		else
//			System.out.println("emp not createsd");
//		System.out.println("--------------------------------");
//		if(e.createEmployee(new Employee())==true)
//		System.out.println(e.toString());
//		else
//			System.out.println("emp not createsd");
//		System.out.println("--------------------------------");
//		e.getEmployees();
//		System.out.println(e.toString());
//		System.out.println("--------------------------------");
//		System.out.println(e.getEmployee(10).toString());
//		//System.out.println(e.toString());
//		System.out.println("--------------------------------");
//		System.out.println(e.getEmployee(100).toString());
//		System.out.println(e.toString());
//		
//
//		
//	}
}
