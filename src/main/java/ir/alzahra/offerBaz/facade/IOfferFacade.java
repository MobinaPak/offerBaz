package ir.alzahra.offerBaz.facade;
import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Mobina Pak
 * @Date: 5/3/2019
 **/
public interface IOfferFacade {

    @Transactional(rollbackFor = Exception.class)
    void insertProduct(ProductDTO productDTO) throws BaseException;

    @Transactional(rollbackFor = Exception.class)
    void insertBank(BankDTO bankDTO) throws BaseException;

    @Transactional(rollbackFor = Exception.class)
    List<BankDTO> getAllBanks()throws BaseException;

    @Transactional(rollbackFor = Exception.class)
    void updateBank(BankDTO bankDTO)throws BaseException;

    @Transactional(rollbackFor = Exception.class)
    BankDTO findBankByName(String bankName)throws BaseException;

    @Transactional(rollbackFor = Exception.class)
    Object findProductByCode(String trackingCode)throws BaseException;
}
