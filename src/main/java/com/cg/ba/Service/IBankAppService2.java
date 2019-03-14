package com.cg.ba.Service;

import com.cg.ba.DTO.TransactionDetails;

public interface IBankAppService2 {
	int deposit(int accno,int amount);
	int withdrawal(int accno,int amount);
	int showBalance(int accno);
	int transferFund(TransactionDetails td);

}