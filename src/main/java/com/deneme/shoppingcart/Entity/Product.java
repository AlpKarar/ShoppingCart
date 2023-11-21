package com.deneme.shoppingcart.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pid;

    private String category;
    private String name;
    private List<String> size;
    private double price;

    public Product() {};

    public Product(int pid, String category, String name, List<String> size, double price) {
        this.pid = pid;
        this.category = category;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
