package com.deneme.shoppingcart.Dto;

public class AddCartRequest {

    private int pid;
    private int amount;

    public AddCartRequest(int pid, int amount) {
        this.pid = pid;
        this.amount = amount;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
