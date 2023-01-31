package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;

@CrossOrigin("http://localhost:3010")
@RequestMapping("/api/v1")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{var}")
    public ResponseEntity<Object> getSpecificCategory(@PathVariable String var) {
        switch (var) {
            case "hats":
            case "jackets":
            case "tshirts":
            case "bags":
                return new ResponseEntity<>(productService.getProductsByCategory(var), HttpStatus.OK);
            default:
                return new ResponseEntity<>(productService.getSpecificProductById(Integer.parseInt(var)), HttpStatus.OK);
        }
    }


}
