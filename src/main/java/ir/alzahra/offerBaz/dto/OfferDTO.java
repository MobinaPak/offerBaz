package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.OfferRequestEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class OfferDTO extends BaseDto {

    private Long id;
    private String name;
    private String description;
    @MapTo(targetEntity = ProductEntity.class)
    private ProductDTO product = new ProductDTO();
/*    @MapTo(targetEntity = OfferRequestEntity.class)
    private OfferRequestDTO offerRequest = new OfferRequestDTO();*/


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
/*
    public OfferRequestDTO getOfferRequest() {
        return offerRequest;
    }

    public void setOfferRequest(OfferRequestDTO offerRequest) {
        this.offerRequest = offerRequest;
    }*/
}
