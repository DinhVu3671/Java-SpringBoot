package com.sapo.edu.ex8_security.repository.jpa;


import com.sapo.edu.ex8_security.dto.ProductInCategory;
import com.sapo.edu.ex8_security.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryJPARepository extends JpaRepository<Category, Long> {
//    @Query(value = "SELECT new com.sapo.edu.ex7spring.dto.ProductInCategory(C.name, COALESCE(SUM(P.product_id), 0))\n" +
//            "FROM Category C " +
//            "LEFT JOIN Product P on (P.category_id = c.category_id)" +
//            "GROUP BY (P.category_id)" +
//            "ORDER BY SUM(product_id) DESC")
//    List<ProductInCategory> sumProductInCategory();
    Page<Category> findAll(Pageable pageable);
}
