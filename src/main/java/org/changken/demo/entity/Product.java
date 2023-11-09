package org.changken.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="No")
    private long no;

    @Column(name="Product_Name")
    private String productName;

    @Column(name="Price")
    private double price;

    @Column(name="Fee_Rate")
    private double feeRate;

//    @OneToMany(mappedBy = "product")
//    private List<LikeList> listList;

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

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

//    public List<LikeList> getListList() {
//        return listList;
//    }
//
//    public void setListList(List<LikeList> listList) {
//        this.listList = listList;
//    }
}
