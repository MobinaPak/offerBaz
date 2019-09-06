package ir.alzahra.offerBaz.dto.searchParameter;

/**
 * @author z.moafi
 * @since 28/08/2019
 */
public class ProductSearchParam {

    private Long bankId;
    private String code;
    private String name;


    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
