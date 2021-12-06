package com.sapo.edu.ex8_security.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Setter
@Getter
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_code")
    private int Code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;

    public Category(int categoryCode, String name, String description) {

        this.Code = categoryCode;
//        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

}
