package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService
{
     @Autowired
    ProductRepository db;
     public List<Product> getProducts()
   {
       return db.selectAll();
   }

     public List<Product> getProductsByCategory(String category )
        {
            return db.selectAllOfCategory(category);
        }


     public Product getSpecificProductById(int id)
        {
            return db.getEntireProduct(id);
        }



}
