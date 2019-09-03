package ir.alzahra.offerBaz.control;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.BankEntity;

/**
 * @author z.moafi
 * @since 03/09/2019
 */
public interface IOfferCheckService {


    boolean checkInsertBank(BankEntity bank)throws BaseException;
}
