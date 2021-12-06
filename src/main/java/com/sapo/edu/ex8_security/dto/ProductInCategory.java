package com.sapo.edu.ex8_security.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductInCategory {
    private String categoryName;
    private Long sumProductQuantity;

}
