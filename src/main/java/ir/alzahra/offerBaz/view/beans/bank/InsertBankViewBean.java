package ir.alzahra.offerBaz.view.beans.bank;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: hanieh Moafi
 * @Date: 8/12/2019
 **/
@Component("insertBankViewBean")
@Scope("view")
public class InsertBankViewBean extends BaseBean {


    @Autowired
    private IOfferProxy offerProxy;

    private BankDTO bankDTO;


    public void init(){
        if (Objects.isNull(bankDTO))
            emptyPage();
    }

    private void emptyPage() {
        bankDTO=new BankDTO();
    }

    public BankDTO getBankDTO() {
        return bankDTO;
    }

    public void setBankDTO(BankDTO bankDTO) {
        this.bankDTO = bankDTO;
    }


    public void insert(){
        try {
            offerProxy.insertBank(bankDTO);
            addNotificationMessage();
            emptyPage();
        } catch (BaseException e) {
            handleBaseException(e);
        }


    }


}
