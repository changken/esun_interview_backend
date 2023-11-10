package org.changken.demo.controller;

import org.changken.demo.dao.ProductDAO;
import org.changken.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<Product> listProduct(){
        List<Product> products = new ArrayList<>();
        products.addAll(productDAO.findAll());
        return products;
    }
    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        return productDAO.save(product);
    }

    @Transactional
    @RequestMapping(value="/{no}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public Map<String, Object> update(@PathVariable("no") long no, @RequestBody Product product){
        int row = jdbcTemplate.update("call update_a_product(?,?,?,?)", no, product.getProductName(), product.getPrice(), product.getFeeRate());
        int row2 = jdbcTemplate.update("call update_total_amount_and_fee_after_update_product(?)", no);
        System.out.println("update a product affected rows: " + row);
        System.out.println("update related likelist affected rows: " + row2);
        return null;

    }

    @GetMapping("/{no}")
    public Optional<Product> queryProduct(@PathVariable("no") long no){
        return productDAO.findById(no);
    }

    @DeleteMapping("/{no}")
    public Map deleteProduct(@PathVariable("no") long no){
        Map<String, Object> map = new HashMap<>();
        try {
            productDAO.deleteById(no);
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
