package com.cg.ba.Service;

import com.cg.ba.Dao.BankAppDaoImpl2;
import com.cg.ba.Dao.IBankAppDao2;
import com.cg.ba.DTO.TransactionDetails;

public class BankAppServiceImpl2 implements IBankAppService2{

IBankAppDao2 appDao2 = new BankAppDaoImpl2();
	public int deposit(int accno, int amount) {

		return appDao2.deposit(accno,amount);
	}

	public int withdrawal(int accno, int amount) {

		return appDao2.withdrawal(accno,amount);
	}

	public int showBalance(int accno) {

		return appDao2.showBalance(accno);
	}

	public int transferFund(TransactionDetails td) {

		return appDao2.transferFund(td);
	}

}