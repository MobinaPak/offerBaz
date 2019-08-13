package ir.alzahra.offerBaz.model.dao.impl;

import com.sun.org.apache.xpath.internal.operations.String;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IBankDao;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import org.springframework.stereotype.Repository;

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
        List<BankEntity> banks = query.getResultList();
        if (Objects.nonNull(banks) && banks.size()>0)
            return banks.get(0);
        else
        return null;
    }
}
