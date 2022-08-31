package com.my.Model;

public class Transaction {
    private int id;
    private Item item;
    private int quantity;
    private Order order;

    /**
     * Constructor for transaction
     * @param item
     * @param quantity
     * @param order
     */
    public Transaction(Item item, int  quantity,Order order){
        this.item = item;
        this.quantity = quantity;
        this.order = order;
    }

    /**
     * Empty constructor for transaction
     */
    public Transaction() {
    }


    public Order getOrder() {
        return order;
    }
    public int getId() {
        return id;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
