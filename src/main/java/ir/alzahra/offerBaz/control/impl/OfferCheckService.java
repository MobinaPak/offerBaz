package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IOfferCheckService;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.notify.CustomSpringEvent;
import ir.alzahra.offerBaz.notify.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author z.moafi
 * @since 03/09/2019
 */
@Service
public class OfferCheckService implements IOfferCheckService {


    @Autowired
    private CustomSpringEvent applicationEventPublisher;


    @Override
    public boolean checkInsertBank(BankEntity bank) throws BaseException {
        if (Objects.isNull(bank))
            throw new BaseException("bank.insert.null");
        if (Objects.isNull(bank.getName()) || Objects.equals(bank.getName(),""))
            throw new BaseException("bank.insert.nullName");
        if (Objects.isNull(bank.getNameAbbreviation()) || Objects.equals(bank.getNameAbbreviation(),""))
            throw new BaseException("bank.insert.nullNameAbbreviation");
        return true;
    }
}
