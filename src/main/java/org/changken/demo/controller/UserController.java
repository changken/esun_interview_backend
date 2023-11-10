package org.changken.demo.controller;

import org.changken.demo.dao.UserDAO;
import org.changken.demo.entity.Product;
import org.changken.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@CrossOrigin(maxAge = 3600)
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
            map.put("status", "error");
            map.put("msg", e.getMessage());
        }finally {
            map.put("status", "ok");
            map.put("msg", "anything is ok!");
        }
        return map;
    }
}
