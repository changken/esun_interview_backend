package org.changken.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
    private String userId;

    @Column(name="UserName")
    private String userName;

    @Column(name="Email")
    private String email;

    @Column(name="Account")
    private String account;

//    @OneToMany(mappedBy ="user")
//    List<LikeList> likeList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

//    public List<LikeList> getLikeList() {
//        return likeList;
//    }
//
//    public void setLikeList(List<LikeList> likeList) {
//        this.likeList = likeList;
//    }
}
