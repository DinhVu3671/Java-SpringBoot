package com.sapo.edu.ex8_security.repository;



import com.sapo.edu.ex8_security.model.Category;

import java.util.List;

public interface categoryRepository {
    List<Category> getAllCategory();
    Category getCategoryById(String categoryId);
    int addCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(String category_Id);

}
