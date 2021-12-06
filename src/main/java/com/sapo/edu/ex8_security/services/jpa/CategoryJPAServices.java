package com.sapo.edu.ex8_security.services.jpa;

import com.sapo.edu.ex8_security.dto.ProductInCategory;
import com.sapo.edu.ex8_security.model.Category;
import com.sapo.edu.ex8_security.repository.jpa.CategoryJPARepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryJPAServices {
    private final CategoryJPARepository categoryJPARepository;

    public CategoryJPAServices(com.sapo.edu.ex8_security.repository.jpa.CategoryJPARepository categoryJPARepository) {
        this.categoryJPARepository = categoryJPARepository;
    }

    // Lấy danh sách tất cả Category
    @Transactional
    public List<Category> getAllCategory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryJPARepository.findAll(pageable).toList();
    }

    // Lấy danh sách Category theo Id
    @Transactional
    public Category getCategoryById(int category_id) {
        if (category_id < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "category_id invalid");
        Category category = categoryJPARepository.findById((long) category_id).get();
        return category;
    }

    // Tao moi 1 Category
    @Transactional
    public  Category createNewCategory(Category category) {
        category.setCreateTime(Timestamp.from(Instant.now()));
        category.setUpdateTime(Timestamp.from(Instant.now()));
        categoryJPARepository.save(category);
        return category;
    }

    // Cap nhat mot Category
    @Transactional
    public Category updateCategory (int category_id, Category newCategory){
        Category categoryUpdate = categoryJPARepository.findById((long) category_id).get();

        categoryUpdate.setCode(newCategory.getCode());
        categoryUpdate.setName(newCategory.getName());
        categoryUpdate.setDescription(newCategory.getDescription());
        categoryUpdate.setUpdateTime(Timestamp.from(Instant.now()));

        categoryJPARepository.save(categoryUpdate);
        return categoryUpdate;
    }

    // Xoa mot Category
    @Transactional
    public void deleteCategory(int category_id){
        if (category_id < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "category_id invalid");
        categoryJPARepository.deleteById((long) category_id);
    }

    // Lấy ra số lượng sản phẩm theo từng danh mục
//    @Transactional
//    public List<ProductInCategory> sumProductInCategory(){
//        return categoryJPARepository.sumProductInCategory();
//    }

}
