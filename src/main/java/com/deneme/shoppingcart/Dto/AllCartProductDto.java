package com.deneme.shoppingcart.Dto;

public class AllCartProductDto {
    private int pid;
    private int amount;
    private double price;

    public AllCartProductDto(int pid, int amount, double price) {
        this.pid = pid;
        this.amount = amount;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
