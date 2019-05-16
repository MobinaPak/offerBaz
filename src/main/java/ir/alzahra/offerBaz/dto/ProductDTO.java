package ir.alzahra.offerBaz.dto;
/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class ProductDTO {

    private Long id;
    private String productName;
    private String description;
    private BankDTO bankDTO = new BankDTO();

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

    public BankDTO getBankDTO() {
        return bankDTO;
    }

    public void setBankDTO(BankDTO bankDTO) {
        this.bankDTO = bankDTO;
    }
}
