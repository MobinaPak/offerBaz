package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.OfferRequestDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@Entity
@Table(name="OFFER")
public class OfferEntity extends BaseEntity {

    //private static final long serialVersionUID = 9073510205176823830L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "OFFER_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFER_ID")
    @MapTo(targetEntity = ProductDTO.class)
    private ProductEntity product;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFER_REQUEST_ID")
    @MapTo(targetEntity = OfferRequestDTO.class)
    private OfferRequestEntity offerRequest;*/


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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
/*
    public OfferRequestEntity getOfferRequest() {
        return offerRequest;
    }

    public void setOfferRequest(OfferRequestEntity offerRequest) {
        this.offerRequest = offerRequest;
    }*/
}
