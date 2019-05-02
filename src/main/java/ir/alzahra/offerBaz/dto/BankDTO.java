package ir.alzahra.offerBaz.dto;

import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/

public class BankDTO {

    private Long id;
    private String name;
    private List<ProductDTO> productDTOS;


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
        return productDTOS;
    }

    public void setProductDTOS(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }
}
