package project.pojolibrary.ComplexPayload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;



public class CreateNestedJsonFromPojoClass {
     
	@Test
	public  void nested() throws JsonGenerationException, JsonMappingException, IOException 
	{
		
		NestedPojoClass np= new NestedPojoClass();
		np.setCompanyName("MSE");
		np.setCompanyHOCity("Benagluru");
		np.setCompanyCEO("Amod");
		
		List<String> supportedSalaryBanks = new ArrayList<String>();
		supportedSalaryBanks.add("HDFC");
		supportedSalaryBanks.add("ICICI");
		supportedSalaryBanks.add("AXIS");
		np.setSupportedSalaryBanks(supportedSalaryBanks);
		
		
		List<Integer> pincodesOfCityOffice = new ArrayList<Integer>();
		pincodesOfCityOffice.add(560037);
		pincodesOfCityOffice.add(360034);
		pincodesOfCityOffice.add(456343);
		np.setPincodesOfCityOffice(pincodesOfCityOffice);
		
		
		
		// Create first employee
				Employee amod = new Employee();
				amod.setFirstName("Amod");
				amod.setLastName("Mahajan");
				amod.setAge(28);
				amod.setGender("Male");
				amod.setSalary(10000.56);
				amod.setMarried(false);
		 
				// Create second employee
				Employee animesh = new Employee();
				animesh.setFirstName("Animesh");
				animesh.setLastName("Prashant");
				animesh.setAge(30);
				animesh.setGender("Male");
				animesh.setSalary(20000.56);
				animesh.setMarried(true);
		 
				// Create third employee
				Employee kitty = new Employee();
				kitty.setFirstName("Kitty");
				kitty.setLastName("Gupta");
				kitty.setAge(26);
				kitty.setGender("Female");
				kitty.setSalary(30000.56);
				kitty.setMarried(false);
		 
				// Creating a List of Employees
				List<Employee> allEmployees = new ArrayList<Employee>();
				allEmployees.add(amod);
				allEmployees.add(animesh);
				allEmployees.add(kitty);
				np.setEmployee(allEmployees);
				
				
				
				Contractors seema = new Contractors();
				seema.setFirstName("Seema");
				seema.setLastName("Singh");
				seema.setContractFrom("Jan-2019");
				seema.setContractTo("JAN-2025");
				
				Contractors hari = new Contractors();
				hari.setFirstName("Hari");
				hari.setLastName("Prasad");
				hari.setContractFrom("Jan-2017");
				hari.setContractTo("JAN-2030");
				
				List<Contractors> allContractors = new ArrayList<Contractors>();
				allContractors.add(seema);
				allContractors.add(hari);
				np.setContractors(allContractors);
				
				
				CompanyPfDetails cp= new CompanyPfDetails();
				cp.setPfName("XYZ");
				cp.setPfCity("Bengaluru");
				cp.setPfYear(2023);
				cp.setNoOfEmployees(150);
				
				CompanyPfDetails cp1= new CompanyPfDetails();
				cp1.setPfName("ABC");
				cp1.setPfCity("Hyderabad");
				cp1.setPfYear(2023);
				cp1.setNoOfEmployees(175);
				
				
				
				List<CompanyPfDetails> companyPfDetails = new ArrayList<CompanyPfDetails>();
				companyPfDetails.add(cp);
				companyPfDetails.add(cp1);
			    np.setCompanyPfDetails(companyPfDetails);
			    
			    
			    
			    ObjectMapper objectMapper = new ObjectMapper();
				String nestedJsonPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(np);
				System.out.println(nestedJsonPayload);
		
		
		
		
		
		
		
		
		
		
		
	}

}
