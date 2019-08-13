package ir.alzahra.offerBaz.view.beans.bank;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    public void searchBank(){
        if (bankName.equals("") || bankName.equals(null)){
            //TODO
        }else {
            try {
                offerProxy.findBankByName(bankName);
                addNotificationMessage();
                emptyPage();
            } catch (BaseException e) {
                //TODO
            }
        }

    }

    public void redirectViewProduct(){

    }

    private void emptyPage() {
        selectedBank=new BankDTO();
        bankName=null;
    }

    public void onBankSelected(){

    }
}
