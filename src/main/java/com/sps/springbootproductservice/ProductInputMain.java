package com.sps.springbootproductservice;

import com.sps.springbootproductservice.models.Category;
import com.sps.springbootproductservice.models.Price;
import com.sps.springbootproductservice.models.Product;
import com.sps.springbootproductservice.repositories.CategoryRepository;
import com.sps.springbootproductservice.repositories.PriceRepository;
import com.sps.springbootproductservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductInputMain implements CommandLineRunner {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductInputMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        insertModels();
    }

    private void insertModels() {
        Price price = new Price();
        price.setPrice(1.00);
        priceRepository.save(price);

        Category category = new Category();
        category.setName("Apple Devices");
        categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("The best iPhone Ever");
        product.setCategory(category);
        product.setPrice(price.getPrice());
        productRepository.save(product);

    }
}
