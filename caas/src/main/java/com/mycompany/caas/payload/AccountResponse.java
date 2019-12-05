package com.mycompany.caas.payload;

/**
 * @author dinesh.lohia
 */

public class AccountResponse {
	private Long ledBalance;

	public AccountResponse(final Long ledBalance) {
		this.ledBalance = ledBalance;
	}

	public Long getLedBalance() {
		return ledBalance;
	}

	public void setLedBalance(Long ledBalance) {
		this.ledBalance = ledBalance;
	}

}
