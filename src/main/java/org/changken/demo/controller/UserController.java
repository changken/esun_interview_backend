package org.changken.demo.controller;

import org.changken.demo.dao.UserDAO;
import org.changken.demo.entity.Product;
import org.changken.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("")
    public List<User> listUser(){
        List<User> users = new ArrayList<>();
        users.addAll(userDAO.findAll());
        return users;
    }
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
    public User createUser(@RequestBody User user){
//        Optional<User> query_user = userDAO.findById(user.getUserId());
//        User res = new User();
//        if(query_user.isPresent()){
//            query_user.get().setUserName(user.getUserName());
//            query_user.get().setAccount(user.getAccount());
//            query_user.get().setEmail(user.getEmail());
//
//        }
        return userDAO.save(user);
    }

    @GetMapping("/{userId}")
    public Optional<User> queryUser(@PathVariable("userId") String userId){
        return userDAO.findById(userId);
    }

    @DeleteMapping("/{userId}")
    public Map deleteUser(@PathVariable("userId") String userId){
        Map<String, Object> map = new HashMap<>();
        try {
            userDAO.deleteById(userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            map.put("ok", 200);
        }
        return map;
    }
}
