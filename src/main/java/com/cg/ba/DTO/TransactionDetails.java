package com.cg.ba.DTO;

public class TransactionDetails {
	private int fromAccountNo, toAccountNo, amountTransfered;

	public int getFromAccountNo() {
		return fromAccountNo;
	}

	public void setFromAccountNo(int fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	public int getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(int toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public int getAmountTransfered() {
		return amountTransfered;
	}

	public void setAmountTransfered(int amountTransfered) {
		this.amountTransfered = amountTransfered;
	}


}
