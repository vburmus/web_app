package com.my.Model;

import com.my.DAO.OrderDAO;
import com.my.DAO.TransactionDAO;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Transaction> transactions;
    private LocalDateTime date;
    private int users_id;
    private float summary;


    private TransactionDAO transactionDAO = new TransactionDAO();


    public Order(int users_id) {

        this.transactions = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.users_id = users_id;
        this.summary = 0;
    }
    public Order(){
    }
    public float getSummary() {
        return summary;
    }
    public void setSummary(float summary) {
        this.summary = summary;
    }
    public void addSummary(float sum) {
        this.summary +=sum;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return date.format(dtf);
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public void addTransaction(Transaction nr){
        transactions.add(nr);
        this.transactionDAO.addTransaction(nr);
    }


    public void setDate(String created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        this.date = LocalDateTime.parse(created, formatter);
    }
}
