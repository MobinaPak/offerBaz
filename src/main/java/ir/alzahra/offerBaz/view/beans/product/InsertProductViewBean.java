package ir.alzahra.offerBaz.view.beans.product;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @Author: hanieh Moafi
 * @Date: 5/5/2019
 **/
@Component("insertProductViewBean")
@Scope("view")
public class InsertProductViewBean extends BaseBean{

    @Autowired
    private IOfferProxy offerProxy;

    private ProductDTO productDTO;
    private List<BankDTO> bankDTOS;
    private BankDTO selectedBank;
    private Long bankId;


    public void init() {
        try {
            bankDTOS= offerProxy.getAllBanks();
        } catch (BaseException e) {
            //TODO
        }
        if (Objects.isNull(productDTO))
            emptyPage();


    }


    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public List<BankDTO> getBankDTOS() {
        return bankDTOS;
    }

    public void setBankDTOS(List<BankDTO> bankDTOS) {
        this.bankDTOS = bankDTOS;
    }

    public BankDTO getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(BankDTO selectedBank) {
        this.selectedBank = selectedBank;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    private void emptyPage() {
        productDTO = new ProductDTO();


    }

    public void findBank(){
        for (BankDTO b:bankDTOS
             ) {
            if (b.getId()==bankId)
                selectedBank=b;

        }

    }

    public void insert() {
        try {

            //offerProxy.insert(productDTO);
            if (Objects.nonNull(productDTO) && Objects.nonNull(selectedBank)) {
                selectedBank.getProducts().add(productDTO);
                offerProxy.updateBank(selectedBank);
                addNotificationMessage();
                  emptyPage();
            }
        } catch (BaseException e) {
            //TODO
        }


    }
}
