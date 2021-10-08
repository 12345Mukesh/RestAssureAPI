package JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class ExecuteQuery1 
{
	@Test
   public void executeQuery() throws SQLException
   {
		Connection con=null;
		  try
		  {
			//Step 1: Register the database
		  Driver driverref=new Driver();
		    DriverManager.registerDriver(driverref);
		    //Step 2:establish connection with database
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");
	         //Step 3:issue create statement
	  Statement stat=con.createStatement();
	    //Step 4:Execute the query
	    int result=stat.executeUpdate("insert into customer values('Keerthana','abcd','Bangalore');");
	    if(result==1)
	    {
	     System.out.println("customer is created successfully");
	    }
	    else
	    {
	     System.out.println("query failed");
	    }
	  }
	  catch(Exception e) 
		  {
	   
	  }
	  finally
	  {
	   con.close();
	  }

   }	
}
