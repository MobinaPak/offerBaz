package ir.alzahra.offerBaz.dto;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class ProductDTO extends BaseDto{

    private Long id;
    private String productName;
    private String description;
    private String uniqueCode;
/*    @MapTo(targetEntity = BankEntity.class)
    private BankDTO bank = new BankDTO();*/
/*    @MapTo(targetEntity = OfferEntity.class)
    private List<OfferDTO> offers = new ArrayList<>();*/

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

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
    /*    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }*/

/*    public List<OfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDTO> offers) {
        this.offers = offers;
    }*/
}
