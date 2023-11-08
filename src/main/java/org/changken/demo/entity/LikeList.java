package org.changken.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="likelist")
public class LikeList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SN")
    private long sn;

    @Column(name="OrderAmount")
    private long orderAmount;

    @Column(name="Account")
    private String account;

    @Column(name="TotalFee")
    private double totalFee;
    @Column(name="TotalAmount")
    private double totalAmount;

    @Column(name="UserID")
    private String userId;

    @Column(name="Product_No")
    private long productNo;

//    @ManyToOne()
//    private User user;
//
//    @ManyToOne()
//    private Product product;

    public LikeList(){
    }

    public LikeList(long sn, long orderAmount, String account, double totalFee, double totalAmount, String userId, long productNo) {
        this.sn = sn;
        this.orderAmount = orderAmount;
        this.account = account;
        this.totalFee = totalFee;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.productNo = productNo;
    }

    public long getSn() {
        return sn;
    }

    public void setSn(long sn) {
        this.sn = sn;
    }

    public long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
