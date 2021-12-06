package com.sapo.edu.ex8_security.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "product_code")
    private  int Code;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "img_link")
    private String imgLink;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "sold_quantity")
    private int soldQuantity;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;

}
