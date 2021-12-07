package project.pojolibrary;

public class ProjectLib
{
	//initializing global variables
   String createdBy;
   String projectName;
   String status;
   int teamSize;

   
 //creating constructor
   public ProjectLib(String createdBy, String projectName, String status, int teamSize) {
	
	this.createdBy = createdBy;
	this.projectName = projectName;
	this.status = status;
	this.teamSize = teamSize;
}


/**
 * @return the createdBy
 */
public String getCreatedBy() {
	return createdBy;
}


/**
 * @param createdBy the createdBy to set
 */
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}


/**
 * @return the projectName
 */
public String getProjectName() {
	return projectName;
}


/**
 * @param projectName the projectName to set
 */
public void setProjectName(String projectName) {
	this.projectName = projectName;
}


/**
 * @return the status
 */
public String getStatus() {
	return status;
}


/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}


/**
 * @return the teamSize
 */
public int getTeamSize() {
	return teamSize;
}


/**
 * @param teamSize the teamSize to set
 */
public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}
   
	
	
	
	
}
