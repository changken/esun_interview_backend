package org.changken.demo;

import org.changken.demo.dao.UserDAO;
import org.changken.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    UserDAO userDAO;
    @PostMapping("/")
    @PutMapping("/")
    @PatchMapping("/")
    public User createUser(User user){
        return userDAO.save(user);
    }

    @GetMapping("/{userId}")
    public Optional<User> queryUser(@RequestParam("userId") String userId){
        return userDAO.findById(userId);
    }

    @DeleteMapping("/{userId}")
    public Map deleteUser(@RequestParam("userId") String userId){
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
