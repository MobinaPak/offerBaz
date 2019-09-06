package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@NamedQueries(
        {
                @NamedQuery(
                        name = "getAllBanks",
                        query = "from BankEntity b "
                ),
                @NamedQuery(
                        name = "findBankByName",
                        query = "from BankEntity b where b.name=:bankName"
                ),

        }
)
@Entity
@Table(name="BANK")
public class BankEntity extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NAME_ABBREVIATION")
    private String nameAbbreviation;

    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "BANK_ID")
    @MapTo(targetEntity = ProductDTO.class)
    private List<ProductEntity> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public String getNameAbbreviation() {
        return nameAbbreviation;
    }

    public void setNameAbbreviation(String nameAbbreviation) {
        this.nameAbbreviation = nameAbbreviation;
    }
}
