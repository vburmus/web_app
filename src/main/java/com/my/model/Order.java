package com.my.model;

import com.my.dao.TransactionDAO;
import com.my.services.exception.MyException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Transaction> transactions;
    private LocalDateTime date;
    private int users_id;
    private float summary;
    private TransactionDAO transactionDAO ;
    int isReady;


    /**
     * Constructor for order
     * @param users_id
     */
    public Order(int users_id) {

        this.transactions = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.users_id = users_id;
        this.summary = 0;
        this.isReady = 0;
        transactionDAO  = new TransactionDAO();
    }

    /**
     * Empty constructor for order
     *
     */
   public Order(){

   }
    public Order(boolean test){
        this.transactions = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.users_id = users_id;
        this.summary = 0;
        this.isReady = 0;
        transactionDAO = new TransactionDAO(true);
    }
    /**
     * This method adds transaction in order
     * @param nr
     */
    public void addTransaction(Transaction nr) throws MyException {
       Transaction transaction = transactions.stream()
                .filter(x -> x.getItem().getName().equals(nr.getItem().getName()))
                .findAny().orElse(null);
        if(transaction!=null){
            transactions.remove(transaction);
            transaction.setQuantity(transaction.getQuantity() + nr.getQuantity());
            transactionDAO.changeQuantity(transaction, transaction.getQuantity(), true);
            transactions.add(transaction);
        }else{
        transactions.add(nr);
        this.transactionDAO.add(nr);
        }
    }
    public float getSummary() {
        return summary;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public int getId() {
        return id;
    }

    public int getIsReady() {
        return isReady;
    }

    public int getUsers_id() {
        return users_id;
    }
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return date.format(dtf);
    }

    public void setIsReady(int isReady) {
        this.isReady = isReady;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSummary(float summary) {
        this.summary = summary;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
    public void setDate(String created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        this.date = LocalDateTime.parse(created, formatter);
    }


}
