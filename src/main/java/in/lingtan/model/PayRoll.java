package in.lingtan.model;

public class PayRoll {
	
	
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public int getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(int basiPay) {
		this.basicPay = basiPay;
	}
	public int getPfAllowance() {
		return pfAllowance;
	}
	public void setPfAllowance(int pfAllowance) {
		this.pfAllowance = pfAllowance;
	}
	public int getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(int medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public int getTravelAllowance() {
		return travelAllowance;
	}
	public void setTravelAllowance(int travelAllowance) {
		this.travelAllowance = travelAllowance;
	}
	public int getHraAllowance() {
		return hraAllowance;
	}
	public void setHraAllowance(int hraAllowance) {
		this.hraAllowance = hraAllowance;
	}
	public int getFoodAllowance() {
		return foodAllowance;
	}
	public void setFoodAllowance(int foodAllowance) {
		this.foodAllowance = foodAllowance;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public int getPfPercentage() {
		return pfPercentage;
	}
	public void setPfPercentage(int pfPercentage) {
		this.pfPercentage = pfPercentage;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return "PayRoll [employee=" + employee + ", basicPay=" + basicPay + ", pfPercentage=" + pfPercentage
				+ ", salary=" + salary + ", ctc=" + ctc + ", pfAllowance=" + pfAllowance + ", medicalAllowance="
				+ medicalAllowance + ", travelAllowance=" + travelAllowance + ", hraAllowance=" + hraAllowance
				+ ", foodAllowance=" + foodAllowance + ", role=" + role + ", annualBasicPay=" + annualBasicPay
				+ ", annualPfPercentage=" + annualPfPercentage + ", annualSalary=" + annualSalary + ", annualCtc="
				+ annualCtc + ", annualPfAllowance=" + annualPfAllowance + ", annualMedicalAllowance="
				+ annualMedicalAllowance + ", annualTravelAllowance=" + annualTravelAllowance + ", annualHraAllowance="
				+ annualHraAllowance + ", annualFoodAllowance=" + annualFoodAllowance + "]";
	}
	
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	private int basicPay ;
	private int pfPercentage;	
	private int salary;
	private int ctc;
	private int pfAllowance ;
	private int medicalAllowance ;
	private int travelAllowance ;
	private int hraAllowance ;
	private int foodAllowance ;
	private String role;
	
	public int getAnnualBasicPay() {
		return annualBasicPay;
	}
	public void setAnnualBasicPay(int annualBasicPay) {
		this.annualBasicPay = annualBasicPay;
	}
	public int getAnnualPfPercentage() {
		return annualPfPercentage;
	}
	public void setAnnualPfPercentage(int annualPfPercentage) {
		this.annualPfPercentage = annualPfPercentage;
	}
	public int getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	public int getAnnualCtc() {
		return annualCtc;
	}
	public void setAnnualCtc(int annualCtc) {
		this.annualCtc = annualCtc;
	}
	public int getAnnualPfAllowance() {
		return annualPfAllowance;
	}
	public void setAnnualPfAllowance(int annualPfAllowance) {
		this.annualPfAllowance = annualPfAllowance;
	}
	public int getAnnualMedicalAllowance() {
		return annualMedicalAllowance;
	}
	public void setAnnualMedicalAllowance(int annualMedicalAllowance) {
		this.annualMedicalAllowance = annualMedicalAllowance;
	}
	public int getAnnualTravelAllowance() {
		return annualTravelAllowance;
	}
	public void setAnnualTravelAllowance(int annualTravelAllowance) {
		this.annualTravelAllowance = annualTravelAllowance;
	}
	public int getAnnualHraAllowance() {
		return annualHraAllowance;
	}
	public void setAnnualHraAllowance(int annualHraAllowance) {
		this.annualHraAllowance = annualHraAllowance;
	}
	public int getAnnualFoodAllowance() {
		return annualFoodAllowance;
	}
	public void setAnnualFoodAllowance(int annualFoodAllowance) {
		this.annualFoodAllowance = annualFoodAllowance;
	}

	private int annualBasicPay ;
	private int annualPfPercentage;	
	private int annualSalary;
	private int annualCtc;
	private int annualPfAllowance ;
	private int annualMedicalAllowance ;
	private int annualTravelAllowance ;
	private int annualHraAllowance ;
	private int annualFoodAllowance ;
	
	
}
