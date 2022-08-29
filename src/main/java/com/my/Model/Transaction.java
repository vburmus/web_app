package com.my.Model;

public class Transaction {
    private int id;
    private Item item;
    private int quantity;
    private Order order;

    public Transaction(Item item, int  quantity,Order order){
        this.item = item;
        this.quantity = quantity;
        this.order = order;
    }

    public Transaction() {

    }


    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
