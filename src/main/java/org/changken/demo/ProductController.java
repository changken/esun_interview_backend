package org.changken.demo;

import org.changken.demo.dao.ProductDAO;
import org.changken.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;
    @PostMapping("/")
    @PutMapping("/")
    @PatchMapping("/")
    public Product createProduct(Product product){
        return productDAO.save(product);
    }

    @GetMapping("/{no}")
    public Optional<Product> queryProduct(@RequestParam("no") long no){
        return productDAO.findById(no);
    }

    @DeleteMapping("/{id}")
    public Map deleteProduct(@RequestParam("no") long no){
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
