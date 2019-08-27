package ir.alzahra.offerBaz.facade.impl;

import ir.alzahra.offerBaz.config.JPAConfig;
import ir.alzahra.offerBaz.control.IOfferService;
import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.enums.DtoState;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.facade.IOfferFacade;
import ir.alzahra.offerBaz.facade.mapper.MapperClass;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Mobina Pak
 * @Date: 5/3/2019
 **/
@Service
public class OfferFacade  implements IOfferFacade {

    @Autowired
    private IOfferService offerService;


    @Override
    public void insertProduct(ProductDTO productDTO) throws BaseException {
        ProductEntity p= MapperClass.mapper(new ProductEntity(),productDTO);
        offerService.insertProduct(p);


    }

    @Override
    public void insertBank(BankDTO bankDTO) throws BaseException {
        BankEntity bankEntity=MapperClass.mapper(new BankEntity(),bankDTO);
        offerService.insertBank(bankEntity);
    }

    @Override
    public List<BankDTO> getAllBanks() throws BaseException {
       List<BankEntity> bankEntities=offerService.getAllBanks();
       List<BankDTO> bankDTOS=new ArrayList<>();
        if (Objects.nonNull(bankEntities)&& bankEntities.size()!=0){
           for (BankEntity b:bankEntities
                ) {
               bankDTOS.add(MapperClass.mapper(new BankDTO(),b));

           }
       }
       return bankDTOS;
    }

    @Override
    public void updateBank(BankDTO bankDTO) throws BaseException {
        List<ProductDTO> productDTOS = bankDTO.getProducts();
        for (ProductDTO p :productDTOS
             ) {
            if (p.getDtoState().equals(DtoState.New)) {
                p.setDtoState(DtoState.None);
                p.setUniqueCode(bankDTO.getNameAbbreviation()+offerService.generateUniqueCode());
            }
        }
        BankEntity bankEntity=MapperClass.mapper(new BankEntity(),bankDTO);
        offerService.updateBank(bankEntity);
    }

    @Override
    public BankDTO findBankByName(String bankName) throws BaseException {
        BankEntity bank=offerService.findBankByName(bankName);
        return MapperClass.mapper(new BankDTO(),bank);
    }

    @Override
    public Object findProductByCode(String trackingCode) throws BaseException {
        ProductEntity p = offerService.findProductByCode(trackingCode);
        return MapperClass.mapper(new ProductDTO(),p);
    }

//    public void initializeDataBase() throws BaseException {
//        offerService.initializeDatabase("dropSessionSequence.txt");
//        offerService.initializeDatabase("createSessionSequence.txt");
//    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        if (JPAConfig.state.equals("create")){
//            try {
//               initializeDataBase();
//    } catch (BaseException e) {
//        e.printStackTrace();
//    }
//}
//    }


}
