package np.com.sunilbist.crudapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	
private String employeeName;
private String employeeAddress;

public Employee() {
	
}

public Employee(int id, String employeeName, String employeeAddress) {
	
	this.id = id;
	this.employeeName = employeeName;
	this.employeeAddress = employeeAddress;
}
public Employee(String employeeName, String employeeAddress) {
	

	this.employeeName = employeeName;
	this.employeeAddress = employeeAddress;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public String getEmployeeAddress() {
	return employeeAddress;
}

public void setEmployeeAddress(String employeeAddress) {
	this.employeeAddress = employeeAddress;
}

}
