package com.sapo.edu.ex8_security.services.jpa;

import com.sapo.edu.ex8_security.model.Product;
import com.sapo.edu.ex8_security.repository.jpa.ProductJPARepository;
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
public class ProductJPAServices {
    private final ProductJPARepository productJPARepository;

    public ProductJPAServices(com.sapo.edu.ex8_security.repository.jpa.ProductJPARepository productJPARepository) {
        this.productJPARepository = productJPARepository;
    }


    // Lấy danh sách tất cả Product
    @Transactional
    public List<Product> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productJPARepository.findAll(pageable).toList();
    }

    // Lấy danh sách Product theo Id
    @Transactional
    public Product getProductById(int product_id) {
        if (product_id < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product_id invalid");
        Product product = productJPARepository.findById((long) product_id).get();
        return product;
    }

    // Tao moi 1 Product
    @Transactional
    public Product createNewProduct(Product product) {
        product.setCreateTime(Timestamp.from(Instant.now()));
        product.setUpdateTime(Timestamp.from(Instant.now()));
        productJPARepository.save(product);
        return product;
    }

    // Cap nhat mot Category
    @Transactional
    public Product updateProduct (int product_id, Product newProduct){
        Product productUpdate = productJPARepository.findById((long) product_id).get();

        productUpdate.setCode(newProduct.getCode());
        productUpdate.setStoreId(newProduct.getStoreId());
        productUpdate.setCategoryId(newProduct.getCategoryId());
        productUpdate.setName(newProduct.getName());
        productUpdate.setDescription(newProduct.getDescription());
        productUpdate.setImgLink(newProduct.getImgLink());
        productUpdate.setQuantity(newProduct.getQuantity());
        productUpdate.setSoldQuantity(newProduct.getSoldQuantity());
        productUpdate.setUpdateTime(Timestamp.from(Instant.now()));

        productJPARepository.save(productUpdate);
        return productUpdate;
    }

    // Xoa mot Product
    @Transactional
    public void deleteProduct(int product_id){
        if (product_id < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product_id invalid");
        productJPARepository.deleteById((long) product_id);
    }

    // Lấy ra Product theo name và name-category
//    @Transactional
//    public List<Product> findByNameAndCategory(String nameProduct, String categoryProduct){
//        return productJPARepository.findByNameAndCategory(nameProduct, categoryProduct);
//    }

    // Lấy ra top sản phẩm có số lượng bán nhiều nhất
    @Transactional
    public List<Product> getTopSaleProducts(int limit){
        return productJPARepository.getTopSaleProducts(limit);
    }

}

