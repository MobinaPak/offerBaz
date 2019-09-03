package ir.alzahra.offerBaz.control.impl;


import ir.alzahra.offerBaz.control.IOfferCheckService;
import ir.alzahra.offerBaz.control.IOfferService;
import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IBankDao;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.dao.impl.ProductDao;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import ir.alzahra.offerBaz.notify.CustomSpringEvent;
import ir.alzahra.offerBaz.notify.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Author: Mobina Pak
 * @Date: 5/3/2019
 **/
@Service
public class OfferServiceImpl implements IOfferService {

    @Autowired
    private IProductDao productDao;

    @Autowired
    private IBankDao bankDao;

    @Autowired
    private CustomSpringEvent applicationEventPublisher;

    @Autowired
    private IOfferCheckService offerCheckService;

    private String finalcode;

    @Override
    public void insertProduct(ProductEntity productEntity) throws BaseException{
        productDao.insert(productEntity);
        applicationEventPublisher.notify("product.insert.success", NotificationType.Info);

    }

    public String generateUniqueCode(String name2) throws BaseException {
       long code = bankDao.getCountOfRecord()+1000;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDateTime now = LocalDateTime.now();
        finalcode =dtf.format(now)+name2+code;
       return finalcode;
    }

//    public void initializeDatabase(String name) throws BaseException {
//        productDao.initializeDatabase(name);
//
//    }

    @Override
    public void insertBank(BankEntity bank) throws BaseException {
        offerCheckService.checkInsertBank(bank);
        bankDao.insert(bank);
        applicationEventPublisher.notify("bank.insert.success", NotificationType.Info);

    }

    @Override
    public List<BankEntity> getAllBanks() throws BaseException {
       return bankDao.getAllBanks();
    }

    @Override
    public void updateBank(BankEntity bankEntity,String trackCode) throws BaseException {
        bankDao.update(bankEntity);
        applicationEventPublisher.notify("product.insert.success",new Object[]{trackCode}, NotificationType.Info);

    }

    @Override
    public BankEntity findBankByName(String bankName) throws BaseException {
       return bankDao.findByName(bankName);
    }

    @Override
    public ProductEntity findProductByCode(String trackingCode) throws BaseException {
        return productDao.findProductByCode(trackingCode);
    }

    @Override
    public void updateProduct(ProductEntity productEntity) throws BaseException {
        productDao.update(productEntity);
        applicationEventPublisher.notify("product.update.success", NotificationType.Info);
    }

    @Override
    public void deleteProduct(ProductEntity productEntity) throws BaseException {
        productDao.delete(productEntity);
        applicationEventPublisher.notify("product.delete.success", NotificationType.Info);

    }

    @Override
    public String findBankByAbbreviation(String name) throws BaseException {
        return bankDao.findBankByAbbreviation(name);
    }

    @Override
    public List<ProductEntity> searchProductByParam(Long param) throws BaseException {
        return productDao.searchProductByParam(param);

    }

    @Override
    public List<BankEntity> searchBankByParam(String bankName) throws BaseException {
        return bankDao.findBankByParam(bankName);
    }
}
