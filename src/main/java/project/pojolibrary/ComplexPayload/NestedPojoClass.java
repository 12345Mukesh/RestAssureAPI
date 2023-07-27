package project.pojolibrary.ComplexPayload;

import java.util.List;

public class NestedPojoClass 
{

	private String companyName;
	private String companyHOCity;
	private String companyCEO;
	private List<String> supportedSalaryBanks;
	private List<Integer> pincodesOfCityOffice;
	List<Employee> employee;
	List<Contractors> contractors;
	
	//we can give two methods like list and directly CompanyPfDetails
	List<CompanyPfDetails> CompanyPfDetails;
	//CompanyPfDetails companyPfDetails;
	
	
	
	//constructor not generating because of list is there which will not come into constructor data
	
//	public NestedPojoClass(String companyName, String companyHOCity, String companyCEO,
//			List<String> supportedSalaryBanks, List<Integer> pincodesOfCityOffice, List<Employee> employee,
//			List<Contractors> contractors, List<project.pojolibrary.ComplexPayload.CompanyPfDetails> companyPfDetails) 
//	{
//		this.companyName = companyName;
//		this.companyHOCity = companyHOCity;
//		this.companyCEO = companyCEO;
//		this.supportedSalaryBanks = supportedSalaryBanks;
//		this.pincodesOfCityOffice = pincodesOfCityOffice;
//		this.employee = employee;
//		this.contractors = contractors;
//		CompanyPfDetails = companyPfDetails;
//	}
//	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyHOCity() {
		return companyHOCity;
	}
	public void setCompanyHOCity(String companyHOCity) {
		this.companyHOCity = companyHOCity;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	
	
	
	
	public List<String> getSupportedSalaryBanks() {
		return supportedSalaryBanks;
	}
	public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
		this.supportedSalaryBanks = supportedSalaryBanks;
	}
	public List<Integer> getPincodesOfCityOffice() {
		return pincodesOfCityOffice;
	}
	public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
		this.pincodesOfCityOffice = pincodesOfCityOffice;
	}
	
	//Already created Employee, Contractors, CompanyPfDetails will be taking directly not initializing again because it is not variable
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Contractors> getContractors() {
		return contractors;
	}
	public void setContractors(List<Contractors> contractors) {
		this.contractors = contractors;
	}
	
	public List<CompanyPfDetails> getCompanyPfDetails() {
		return CompanyPfDetails;
	}
	public void setCompanyPfDetails(List<CompanyPfDetails> companyPfDetails) {
		CompanyPfDetails = companyPfDetails;
	}
	
	
	
	
	
	
}
