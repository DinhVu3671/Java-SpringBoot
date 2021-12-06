package com.sapo.edu.ex8_security.controller;

import com.sapo.edu.ex8_security.model.Product;
import com.sapo.edu.ex8_security.services.jpa.ProductJPAServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ProductController {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductJPAServices productJPAServices;

    // lấy ra tất cả danh sách product
    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam("page") int page, @RequestParam("size") int size){
        List<Product> listAllProduct= productJPAServices.getAllProduct(page, size);
        if(listAllProduct.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(listAllProduct, HttpStatus.OK);
    }

    // lấy store theo product_id
    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getStoreById(@PathVariable int product_id) {
        Product product = productJPAServices.getProductById(product_id);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Cập nhật thông tin một product
    @PutMapping("/{product_id}")
    public ResponseEntity<Product> updateStoreById(@PathVariable(value = "product_id") int product_id,
                                                  @Valid @RequestBody Product productNew) {
        return new ResponseEntity<Product>(productJPAServices.updateProduct(product_id, productNew), HttpStatus.OK);

    }

    // Thêm 1 product mới
    @PostMapping
    public ResponseEntity<Product> createNewProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productJPAServices.createNewProduct(product), HttpStatus.OK);
    }

    // Xoá 1 product
    @DeleteMapping("/{product_id}")
    public ResponseEntity deleteProduct(@PathVariable(value = "product_id") int product_id) {
        Product product = productJPAServices.getProductById(product_id);
        if(product != null) {
            productJPAServices.deleteProduct(product_id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // lấy ra product theo name và category-name
//    @GetMapping(value = "filter")
//    public ResponseEntity<?> findByNameAndCategory(@RequestParam String nameProduct, @RequestParam String categoryName) {
//        List<Product> products = productJPAServices.findByNameAndCategory(nameProduct, categoryName);
//        return ResponseEntity.ok().body(products);
//    }

    // Lấy ra top product bán được nhiều nhất
//    @GetMapping(value = "top")
//    public ResponseEntity<?> getTopSaleProducts(@RequestParam int limit) {
//        List<Product> products = productJPAServices.getTopSaleProducts(limit);
//        return ResponseEntity.ok().body(products);
//    }

}

