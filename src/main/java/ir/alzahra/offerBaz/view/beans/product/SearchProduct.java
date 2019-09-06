package ir.alzahra.offerBaz.view.beans.product;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author z.moafi
 * @since 01/09/2019
 */
@Component("searchProduct")
@Scope("view")
public class SearchProduct extends BaseBean {

    @Autowired
    private IOfferProxy offerProxy;

    private List<BankDTO> bankDTOS;
    private Long bankId;
    private List<ProductDTO> products;
    private ProductDTO selectedProduct;



    public void init(){
        try {
            bankDTOS= offerProxy.getAllBanks();
        } catch (BaseException e) {
            handleBaseException(e);
        }

    }

    public List<BankDTO> getBankDTOS() {
        return bankDTOS;
    }

    public void setBankDTOS(List<BankDTO> bankDTOS) {
        this.bankDTOS = bankDTOS;
    }


    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public ProductDTO getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductDTO selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void searchProduct(){
        try {
        if (Objects.nonNull(bankId)) {
                products=offerProxy.searchProduct(bankId);
        }else{
            throw new BaseException("product.insert.bankNotSelect");
        }
        } catch (BaseException e) {
           handleBaseException(e);
        }
    }

    public void onFoundProductTableRowDbClick(final SelectEvent event){
        if (event.getObject() != null) {
            selectedProduct = (ProductDTO) event.getObject();
            RequestContext.getCurrentInstance().closeDialog(selectedProduct);
        }
    }

    public void select(){
        if (selectedProduct != null)
            RequestContext.getCurrentInstance().closeDialog(selectedProduct);
        else{
            //TODO
        }

    }

    public void close(){
        RequestContext.getCurrentInstance().closeDialog(null);

    }


}
