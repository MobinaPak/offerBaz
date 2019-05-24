package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.OfferDTO;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@Entity
@Table(name="PRODUCT")
public class ProductEntity extends BaseEntity {

    private static final long serialVersionUID = -7140560430822563744L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFER_ID")
    @MapTo(targetEntity = OfferDTO.class)
    private List<OfferEntity> offers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ID")
    @MapTo(targetEntity = BankDTO.class)
    private BankEntity bank = new BankEntity();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferEntity> offers) {
        this.offers = offers;
    }

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }
}
