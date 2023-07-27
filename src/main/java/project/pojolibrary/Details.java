package project.pojolibrary;

public class Details
{
  private String Companyname;
  private String EmailId;
  
  
  public Details(String Companyname, String EmailId)
  {
	  this.Companyname=Companyname;
	  this.EmailId=EmailId;
  }
	
	
  public void setCompanyname(String Companyname)
  {
	this.Companyname=Companyname;  
  }
  
  public void setEmailId(String EmailId)
  {
	  this.EmailId=EmailId;
  }
  
  
  public String getCompanyname()
  {
	  return Companyname;
  }
  
  
  public String getEmailId()
  {
	  return EmailId;
  }
  
  
  
  
  
  
  
  
  
  
}
