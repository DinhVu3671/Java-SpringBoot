package com.sapo.edu.ex8_security.controller;


import com.sapo.edu.ex8_security.dto.ProductInCategory;
import com.sapo.edu.ex8_security.model.Category;
import com.sapo.edu.ex8_security.services.jpa.CategoryJPAServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/admin/category")
public class CategoryController {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryJPAServices categoryJPAServices;

    // Lấy ra tất cả danh sách category
    @GetMapping
    public ResponseEntity<List<Category>> listCategory(@RequestParam("page") int page, @RequestParam("size") int size){
        List<Category> listAllCategory= categoryJPAServices.getAllCategory(page, size);
        if(listAllCategory.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(listAllCategory, HttpStatus.OK);
    }

    // lấy category theo category_id
    @GetMapping("/{category_id}")
    public ResponseEntity<Category> getStoreById(@PathVariable int category_id) {
        Category category = categoryJPAServices.getCategoryById(category_id);
//        if(category != null){
        return new ResponseEntity<Category>(category, HttpStatus.OK);
//        }
//        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Cập nhật thông tin một Category
    @PutMapping("/{category_id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable(value = "category_id") int category_id,
                                                 @Valid @RequestBody Category categoryNew) {
        Category categoryUpdate = categoryJPAServices.updateCategory(category_id, categoryNew);
        return new ResponseEntity<Category>(categoryUpdate, HttpStatus.OK);

    }

    // Thêm 1 Category mới
    @PostMapping
    public ResponseEntity<Category> createNewCategory(@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryJPAServices.createNewCategory(category), HttpStatus.OK);
//        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    // Xoá 1 category
    @DeleteMapping("/{category_id}")
    public ResponseEntity deleteStore(@PathVariable(value = "category_id") int category_id) {
        Category category = categoryJPAServices.getCategoryById(category_id);
        if(category != null) {
            categoryJPAServices.deleteCategory(category_id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Đếm số lượng product theo category
//    @GetMapping(value = "/total-product")
//    public ResponseEntity<?> sumProductInCategory(){
//        List<ProductInCategory> productInCategories = categoryJPAServices.sumProductInCategory();
//        return ResponseEntity.ok().body(productInCategories);
//    }

}
