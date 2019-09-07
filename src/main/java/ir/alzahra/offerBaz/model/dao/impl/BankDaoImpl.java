package ir.alzahra.offerBaz.model.dao.impl;


import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IBankDao;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

/**
 * @Author: hanieh Moafi
 * @Date: 8/12/2019
 **/
@Repository
public class BankDaoImpl extends AbstractDAO implements IBankDao {
    @Override
    public void insert(BankEntity bank) {
       entityManager.persist(bank);
    }

    @Override
    public void update(BankEntity bankEntity) {
        entityManager.merge(bankEntity);

    }

    @Override
    public void delete(BankEntity bankEntity) {
//        entityManager.remove(bankEntity);
        entityManager.remove(entityManager.contains(bankEntity) ? bankEntity : entityManager.merge(bankEntity));

    }

    @Override
    public List<BankEntity> getAllBanks() throws BaseException {
        TypedQuery query = entityManager.createNamedQuery("getAllBanks",BankEntity.class);
        List<BankEntity> banks=query.getResultList();
        return banks;
    }

    @Override
    public BankEntity findByName(String bankName) throws BaseException {
        TypedQuery query =entityManager.createNamedQuery("findBankByName",BankEntity.class);
        query.setParameter("bankName",bankName);
        List<BankEntity> banks = query.getResultList();
        if (Objects.nonNull(banks) && banks.size()>0)
            return banks.get(0);
        else
        return null;
    }



    @Override
    public String findBankByAbbreviation(String name) throws BaseException {
        String query="select b.NAME from BANK b where b.NAME_ABBREVIATION =:name1";
        Query statement=entityManager.createNativeQuery(query);
        statement.setParameter("name1",name);
        List<String> names=statement.getResultList();
        if (Objects.nonNull(names) && names.size()>0)
            return names.get(0);
        else return null;

    }

    @Override
    public List<BankEntity> findBankByParam(String bankName) throws BaseException {
        String query="select * from BANK b where (b.NAME='' or b.NAME like :bankName)";
        Query statement=entityManager.createNativeQuery(query,BankEntity.class);
        statement.setParameter("bankName","%"+bankName+"%");
        return statement.getResultList();
    }
}
