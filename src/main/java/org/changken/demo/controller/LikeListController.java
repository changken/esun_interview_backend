package org.changken.demo.controller;

import org.changken.demo.entity.LikeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/likelist")
public class LikeListController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<Map<String, Object>> list(){
        List<Map<String, Object>> map = jdbcTemplate.queryForList("call list_all_of_like_item()", new BeanPropertyRowMapper<LikeList>(LikeList.class));
        return map;
    }

    @PostMapping("")
    public Map create(@RequestBody LikeList likeList){
        Map<String, Object> map = new HashMap<>();
        int rows = jdbcTemplate.update("call create_a_like_item(?, ?, ?, ?, ?, ?)",
                likeList.getOrderAmount(),
                likeList.getAccount(),
                likeList.getTotalFee(),
                likeList.getTotalAmount(),
                likeList.getUserId(),
                likeList.getProductNo()
        );
        map.put("affect_row", rows);
        return map;
    }

    @PutMapping("/{sn}")
    @PatchMapping("/{sn}")
    public Map update(@PathVariable("sn") long sn, @RequestBody LikeList likeList){
        Map<String, Object> map = new HashMap<>();
        int rows = jdbcTemplate.update("call update_a_like_item(?, ?, ?, ?, ?, ?, ?)",
                sn,
                likeList.getOrderAmount(),
                likeList.getAccount(),
                likeList.getTotalFee(),
                likeList.getTotalAmount(),
                likeList.getUserId(),
                likeList.getProductNo()
        );
        map.put("affect_row", rows);
        return map;
    }

    @DeleteMapping("/{sn}")
    public Map delete(@PathVariable("sn") long sn){
        Map<String, Object> map = new HashMap<>();
        int rows = jdbcTemplate.update("call delete_a_like_item(?)",
                sn
        );
        map.put("affect_row", rows);
        return map;
    }

}
