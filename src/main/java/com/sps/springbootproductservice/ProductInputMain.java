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

import java.util.List;

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
        getProductsWithJPABuiltQuery();
        getProductWithJPACustomQuery();
    }


    private void insertModels() {
        Price price = new Price();
        price.setPrice(1.00);
        price.setCurrency("Rupees");
        //priceRepository.save(price); Commented since cascade is enabled

        System.out.println("********************* Saving Category *********************");
        Category category = new Category();
        category.setName("Apple Devices");
        categoryRepository.save(category);

        System.out.println("********************* Saving Product with Price Cascade *********************");
        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("The best iPhone Ever");
        product.setCategory(category);
        product.setPrice(price);
        productRepository.save(product);
    }

    private void getProductsWithJPABuiltQuery() {
        System.out.println("********************* Get Products with JPA Built Query *********************");
        List<Product> productList = productRepository.findAll();
        productList.forEach(product -> System.out.println(product.getTitle()));
    }

    private void getProductWithJPACustomQuery() {
        System.out.println("********************* Product title from Query *********************");
        Product product = productRepository.findByTitleEqualsAndPrice_Price("iPhone 15 Pro", 1.00);
        System.out.println(product);

        System.out.println("********************* Printing Products based on Currency *********************");
        List<Product> productList = productRepository.findAllByPrice_Currency("Rupees");
        productList.forEach(System.out::println);

        System.out.println("********************* Count Products by Price *********************");
        int count = productRepository.countAllByPrice_Price(1.00);
        System.out.println(count + " Number of Products are there for price 1.00");

        System.out.println("********************* Get Products using native Query *********************");
        List<Product> productsWithQuery = productRepository.findByTitleWithNativeQuery("iPhone 15 Pro");
        productsWithQuery.forEach(System.out::println);

    }
}
