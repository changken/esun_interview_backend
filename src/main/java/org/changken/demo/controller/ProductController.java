package org.changken.demo.controller;

import org.changken.demo.dao.ProductDAO;
import org.changken.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("")
    public List<Product> listProduct(){
        List<Product> products = new ArrayList<>();
        products.addAll(productDAO.findAll());
        return products;
    }

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
    public Product createProduct(@RequestBody Product product){
        return productDAO.save(product);
    }

    @GetMapping("/{no}")
    public Optional<Product> queryProduct(@PathVariable("no") long no){
        return productDAO.findById(no);
    }

    @DeleteMapping("/{id}")
    public Map deleteProduct(@PathVariable("no") long no){
        Map<String, Object> map = new HashMap<>();
        try {
            productDAO.deleteById(no);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            map.put("ok", 200);
        }
        return map;
    }
}
