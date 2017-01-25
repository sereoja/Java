/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.Serializable;

/**
 *
 * @author sungureanu
 */

    public class Account implements Serializable {
    private int accountNumber;
    private double balance;
    private String type;
    private String bank;

    public Account(int accountNumber, double balance, String type, String bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.bank = bank;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public String getBank() {
        return bank;
    }
    
    }
