package in.lingtan.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Employee {

	@Override
	public String toString() {
		return "Employee [name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", employeeID=" + employeeID + ", email=" + email + ", dob=" + dob + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", joiningData=" + joiningData + ", basicPay=" + basicPay
				+ ", salary=" + salary + ", pf=" + pf + ", attendance=" + attendance + ", present=" + present
				+ ", absent=" + absent + ", attendanceStatusForADate=" + attendanceStatusForADate + ", attendanceMap="
				+ attendanceMap + "]";
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

	public LocalDate getJoiningData() {
		return joiningData;
	}

	public void setJoiningData(LocalDate joiningData) {
		this.joiningData = joiningData;
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

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public int getPresent() {
		return present;
	}

	public void setPresent(int present) {
		this.present = present;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

	public String getAttendanceStatusForADate() {
		return attendanceStatusForADate;
	}

	public void setAttendanceStatusForADate(String attendanceStatusForADate) {
		this.attendanceStatusForADate = attendanceStatusForADate;
	}

	public Map<LocalDate, Integer> getAttendanceMap() {
		return attendanceMap;
	}

	public void setAttendanceMap(Map<LocalDate, Integer> attendanceMap) {
		this.attendanceMap = attendanceMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	private String firstName;
	private String lastName;
	private String role;
	private String employeeID;
	private String email;
	private LocalDate dob;
	private String gender;
	private long mobileNumber;
	private LocalDate joiningData;
	private int basicPay;
	private double salary;
	private double pf;
	private int attendance;
	private int present;
	private int absent;
	private String attendanceStatusForADate;
	private Map<LocalDate, Integer> attendanceMap = new HashMap<>();

}
