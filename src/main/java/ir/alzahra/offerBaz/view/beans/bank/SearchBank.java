package ir.alzahra.offerBaz.view.beans.bank;

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
 * @since 02/09/2019
 */

@Component("searchBank")
@Scope("view")
public class SearchBank extends BaseBean {


    @Autowired
    private IOfferProxy offerProxy;

    private String bankName;
    private List<BankDTO> banks;
    private BankDTO selectedBank;




    public void init(){

    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<BankDTO> getBanks() {
        return banks;
    }

    public void setBanks(List<BankDTO> banks) {
        this.banks = banks;
    }

    public BankDTO getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(BankDTO selectedBank) {
        this.selectedBank = selectedBank;
    }

    public void searchBank(){
        if (Objects.equals(bankName,"")){
            try {
                banks=offerProxy.getAllBanks();
            } catch (BaseException e) {
                handleBaseException(e);
            }
        }else{
            try {
                banks=offerProxy.findBankByParam(bankName);
            } catch (BaseException e) {
                handleBaseException(e);
            }
        }

    }
    public void onFoundBankTableRowDbClick(final SelectEvent event) {
        if (event.getObject() != null) {
            selectedBank = (BankDTO) event.getObject();
            RequestContext.getCurrentInstance().closeDialog(selectedBank);
        }
    }

    public void selectBank(){
        if (selectedBank != null)
            RequestContext.getCurrentInstance().closeDialog(selectedBank);
        else{
            //TODO
        }
    }
    public void close(){
        RequestContext.getCurrentInstance().closeDialog(null);

    }
}
