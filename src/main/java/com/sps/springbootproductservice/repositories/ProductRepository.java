package com.sps.springbootproductservice.repositories;

import com.sps.springbootproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitleEqualsAndPrice_Price(String title, double price);

    List<Product> findAllByPrice_Currency(String currency);

    int countAllByPrice_Price(double price);

    @Query(value = "select * from product where title = :title", nativeQuery = true)
    List<Product> findByTitleWithNativeQuery(String title);
}
