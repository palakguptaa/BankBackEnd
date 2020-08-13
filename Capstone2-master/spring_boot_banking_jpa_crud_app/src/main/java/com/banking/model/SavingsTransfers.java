package com.banking.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SavingsTransfers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int savingsTransfersId;
	private Date date;
	private String recipient;
	private long recipientAccountNumber;
	private Double transferAmount;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "savings_account_id")
	private SavingsAccount savingsAccount;
	
	public SavingsTransfers() {
		// TODO Auto-generated constructor stub
	}

	public SavingsTransfers(Date date, String recipient, long recipientAccountNumber, Double transferAmount,
			String status, SavingsAccount savingsAccount) {
		
		this.date = date;
		this.recipient = recipient;
		this.recipientAccountNumber = recipientAccountNumber;
		this.transferAmount = transferAmount;
		this.status = status;
		this.savingsAccount = savingsAccount;
	}




	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	

	public int getSavingsTransfersId() {
		return savingsTransfersId;
	}

	public void setSavingsTransfersId(int savingsTransfersId) {
		this.savingsTransfersId = savingsTransfersId;
	}

	public long getRecipientAccountNumber() {
		return recipientAccountNumber;
	}

	public void setRecipientAccountNumber(long receiverAccountNumber) {
		this.recipientAccountNumber = receiverAccountNumber;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	
	
}
