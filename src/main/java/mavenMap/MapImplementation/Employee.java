package mavenMap.MapImplementation;

import javax.xml.bind.annotation.XmlRootElement;
			


@XmlRootElement
public class Employee {
	
	private int id =0;
	private String name = "null";
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getID() {
		return new Integer(id);
	
	}
	
}
