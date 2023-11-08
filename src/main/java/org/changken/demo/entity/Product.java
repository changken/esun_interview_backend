package org.changken.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String productName;
    private double price;
    private float feeRate;

    @OneToMany(mappedBy = "product")
    private List<LikeList> listList;

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(float feeRate) {
        this.feeRate = feeRate;
    }

    public List<LikeList> getListList() {
        return listList;
    }

    public void setListList(List<LikeList> listList) {
        this.listList = listList;
    }
}
