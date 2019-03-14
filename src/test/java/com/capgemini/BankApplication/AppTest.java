package com.capgemini.BankApplication;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.cg.ba.DTO.CustomerDetails;
import com.cg.ba.Dao.BankAppDaoImpl1;
import com.cg.ba.Dao.BankAppDaoImpl2;
import com.cg.ba.Dao.IBankAppDao1;
import com.cg.ba.Dao.IBankAppDao2;

 
public class AppTest 
{
	
	//@BeforeAll
	
	CustomerDetails custdetails;
	IBankAppDao1 bd1 ;
	IBankAppDao2 bd2;
	
	
	void init(){
		
		custdetails = new CustomerDetails();
		bd1 = new BankAppDaoImpl1();
		bd2 = new BankAppDaoImpl2();

	}
    
    @Test
    public void testRegisterCustomer()
    {
    	
    	custdetails.setFirstName("Tejaswi");
    	custdetails.setLastName("Tatireddy");
    	custdetails.setEmailId("teja@gmail.com");
    	custdetails.setPassword("teja123");
    	custdetails.setPancardNo("agfhf5464");
    	custdetails.setAadharNo("122334455667");
    	custdetails.setAddress("Banglore");
    	custdetails.setMobile(15678);
    	custdetails.setBalance(0);
    	
        assertEqual(1003,bd1.registerCustomer(custdetails));
    }
}
