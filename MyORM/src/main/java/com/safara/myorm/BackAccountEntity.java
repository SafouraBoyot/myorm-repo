package com.safara.myorm;

/**
 *
 * @author safoura
 */
@Table(name = "tbl_account")
public class BackAccountEntity {

    private int accountNumber;
    private String owner;
    private long balance;
	
    @Column(name = "f_number")
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "f_owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Column(name = "f_balance")
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}