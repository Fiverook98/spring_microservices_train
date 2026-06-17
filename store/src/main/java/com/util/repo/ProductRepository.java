package com.util.repo;

import com.util.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Transactional
    @Modifying
    @Query("delete from Product p where p.code = ?1")
    int deleteByCode(String code);

    @Transactional
    @Modifying
    @Query("update Product p set p.price = ?2 where p.code = ?1")
    int updatePriceByCode(String code, BigDecimal price);

    @Query("from Product p where p.code = ?1")
    Product getByCode(String code);
}
 