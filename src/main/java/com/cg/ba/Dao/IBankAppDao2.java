package com.cg.ba.Dao;

import com.cg.ba.DTO.TransactionDetails;

public interface IBankAppDao2 {
	int deposit(int accno,int amount);
	int withdrawal(int accno,int amount);
	int showBalance(int accno);
	int transferFund(TransactionDetails td);

}