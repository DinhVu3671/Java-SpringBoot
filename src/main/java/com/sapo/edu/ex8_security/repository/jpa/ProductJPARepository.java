package com.sapo.edu.ex8_security.repository.jpa;

import com.sapo.edu.ex8_security.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJPARepository extends JpaRepository<Product, Long> {

//    @Query(value = "SELECT * FROM ("
//            + " (SELECT * FROM products WHERE LOWER(name) LIKE CONCAT('%', :name, '%')) as sp"
//            + " JOIN (SELECT * FROM categories WHERE LOWER(name) = :category) as C"
//            + " ON sp.category_id = C.category_id)", nativeQuery = true)
//    List<Product> findByNameAndCategory(@Param("name") String productName, @Param("category") String categoryName);

    @Query(value = "CALL get_top_sale_products(:limit);", nativeQuery = true)
    List<Product> getTopSaleProducts(@Param("limit") Integer limit);

}

