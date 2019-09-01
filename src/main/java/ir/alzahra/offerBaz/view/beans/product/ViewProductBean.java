package ir.alzahra.offerBaz.view.beans.product;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.enums.DtoState;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author z.moafi
 * @since 28/08/2019
 */
@Component("viewProductBean")
@Scope("view")
public class ViewProductBean extends BaseBean {

    private String productCode;
    private ProductSearchParam productSearchParam;
    private List<BankDTO> bankDTOS;
    private ProductDTO selectedProduct;
    private String bankName;

    @Autowired
    private IOfferProxy offerProxy;


    public void init() {
        emptyPage();

        try {
            bankDTOS = offerProxy.getAllBanks();
        } catch (BaseException e) {
            //TODO
        }

    }

    private void emptyPage() {
        productSearchParam = new ProductSearchParam();
        selectedProduct = new ProductDTO();

    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public ProductSearchParam getProductSearchParam() {
        return productSearchParam;
    }

    public void setProductSearchParam(ProductSearchParam productSearchParam) {
        this.productSearchParam = productSearchParam;
    }

    public List<BankDTO> getBankDTOS() {
        return bankDTOS;
    }

    public void setBankDTOS(List<BankDTO> bankDTOS) {
        this.bankDTOS = bankDTOS;
    }

    public ProductDTO getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductDTO selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void searchProduct() {
        try {
            selectedProduct = offerProxy.findProduct(productCode);
            bankName = offerProxy.findBankByAbbreviation(selectedProduct.getUniqueCode().substring(6, 9));
            addNotificationMessage();
            //emptyPage();
        } catch (BaseException e) {
            //TODO
        }


    }

}
