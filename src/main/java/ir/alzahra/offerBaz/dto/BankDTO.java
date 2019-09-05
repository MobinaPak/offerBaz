package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.enums.DtoState;
import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/

public class BankDTO extends BaseDto{

    private Long id;
    private String name;
    private String nameAbbreviation;

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

    public List<ProductDTO> getProducts() {

        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public String getNameAbbreviation() {
        return nameAbbreviation;
    }

    public void setNameAbbreviation(String nameAbbreviation) {
        this.nameAbbreviation = nameAbbreviation;
    }
}
