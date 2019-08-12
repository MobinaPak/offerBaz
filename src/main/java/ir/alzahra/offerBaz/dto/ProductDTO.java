package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.OfferEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;
/*    @MapTo(targetEntity = BankEntity.class)
    private BankDTO bank = new BankDTO();*/
    @MapTo(targetEntity = OfferEntity.class)
    private List<OfferDTO> offers = new ArrayList<>();

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

/*    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }*/

    public List<OfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDTO> offers) {
        this.offers = offers;
    }
}
