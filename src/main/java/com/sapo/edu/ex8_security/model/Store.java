package com.sapo.edu.ex8_security.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Table(name="store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "store_id")
    private long storeId;
    @Column(name = "store_code")
    private int code;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;

    public Store(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }
}
