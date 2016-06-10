package com.chatak.iplteams;

/**
 * Created by root on 10/6/16.
 */
public class Product {
    private String cakeId;
    private String title;
    private String weight;
    private double price;

    public Product(String cakeId, String title, String weight, double price) {
        this.cakeId = cakeId;
        this.title = title;
        this.weight = weight;
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCakeId(String cakeId) {
        this.cakeId = cakeId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCakeId() {
        return cakeId;
    }

    public String getTitle() {
        return title;
    }
}
