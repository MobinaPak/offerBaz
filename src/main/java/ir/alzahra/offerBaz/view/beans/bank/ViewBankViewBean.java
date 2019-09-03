package ir.alzahra.offerBaz.view.beans.bank;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import ir.alzahra.offerBaz.view.util.GeneralUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;

/**
 * @author z.moafi
 * @since 13/08/2019
 */
@Component("viewBankViewBean")
@Scope("view")
public class ViewBankViewBean extends BaseBean {

    @Autowired
    private IOfferProxy offerProxy;


    private String bankName;
    private BankDTO selectedBank;
    private ProductDTO selectedProduct;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankDTO getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(BankDTO selectedBank) {
        this.selectedBank = selectedBank;
    }

    public ProductDTO getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductDTO selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void searchBank() {
        if (bankName.equals("") || bankName.equals(null)) {
            GeneralUtil.openWindow("includes/searchBank", new Object[]{true, "850", "520", "100%", "100%", false, false}, "viewObject", null, "viewObject");
        } else {
            try {
                selectedBank = offerProxy.findBankByName(bankName);
            } catch (BaseException e) {
               handleBaseException(e);
            }
        }

    }

    public void redirectViewProduct() {
        if (Objects.nonNull(selectedProduct))
            GeneralUtil.openWindow("includes/viewPro", new Object[]{true, "850", "520", "100%", "100%", false, false}, "viewObject", selectedProduct, "viewObject");
    }



    public void onBankSelected(SelectEvent event){

        Object returnObj = event.getObject();
        if (returnObj != null) {
            selectedBank = (BankDTO) returnObj;
            bankName=selectedBank.getName();

        }


    }

    public void returnProduct(final SelectEvent event) {
        Object returnObj = event.getObject();
        if (returnObj != null) {
//            cardDataTableDto = (CardDataTableDto) returnObj;
//            if (cardDataTableDto.getDtoState() == DtoState.Edit) {

            //  }
        }
    }
}
