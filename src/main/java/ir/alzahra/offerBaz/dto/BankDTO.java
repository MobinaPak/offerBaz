package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/

public class BankDTO {

    private Long id;
    private String name;
    @MapTo(targetEntity = ProductEntity.class)
    private List<ProductDTO> products = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProductDTOS() {
        return products;
    }

    public void setProductDTOS(List<ProductDTO> products) {
        this.products = products;
    }
}
