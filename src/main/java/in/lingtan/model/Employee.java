package in.lingtan.model;

import java.time.LocalDate;


public class Employee {

	@Override
	public String toString() {
		return "Employee [name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", employeeID=" + employeeID + ", email=" + email + ", dob=" + dob + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", joiningDate=" + joiningDate + ", activeStatus=" + activeStatus
				+ ", basicPay=" + basicPay + ", salary=" + salary + ", pf=" + pf + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningData) {
		this.joiningDate = joiningData;
	}

	public int getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}


	private String name;
	private String firstName;
	private String lastName;
	private String role;
	private String employeeID;
	private String password;
	private String email;
	private LocalDate dob;
	private String gender;
	private long mobileNumber;
	private LocalDate joiningDate;
	private int activeStatus;
	private int basicPay;
	private double salary;
	private double pf;
	

}
