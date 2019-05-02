package ir.alzahra.offerBaz.dto;
/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class OfferDTO {

    private Long id;
    private String name;
    private String description;
    private ProductDTO productDTO;


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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
