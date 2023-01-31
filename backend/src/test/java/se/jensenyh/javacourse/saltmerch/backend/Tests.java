package se.jensenyh.javacourse.saltmerch.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.jensenyh.javacourse.saltmerch.backend.controller.ProductController;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class Tests {
    @Autowired
    ProductController productController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(productController).isNotNull();


        productController.getProducts();
    }

}

