package org.changken.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LileListController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int create(){
        return jdbcTemplate.update("insert into `likelist` ");
    }
}
