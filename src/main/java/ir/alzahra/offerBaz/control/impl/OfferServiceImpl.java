package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IOfferService;
import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IBankDao;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import ir.alzahra.offerBaz.notify.CustomSpringEvent;
import ir.alzahra.offerBaz.notify.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void insertProduct(ProductEntity productEntity) throws BaseException{
        productDao.insert(productEntity);
        applicationEventPublisher.notify("product.insert.success", NotificationType.Info);

    }

    @Override
    public void insertBank(BankEntity bank) throws BaseException {
        bankDao.insert(bank);
        applicationEventPublisher.notify("bank.insert.success", NotificationType.Info);

    }

    @Override
    public List<BankEntity> getAllBanks() throws BaseException {
       return bankDao.getAllBanks();
    }

    @Override
    public void updateBank(BankEntity bankEntity) throws BaseException {
        bankDao.update(bankEntity);
        applicationEventPublisher.notify("product.insert.success", NotificationType.Info);

    }
}
