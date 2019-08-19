package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.OfferDTO;
import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@Entity
@Table(name="OFFER_REQUEST")
public class OfferRequestEntity extends BaseEntity {

    //private static final long serialVersionUID = -7400819531205311768L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SALARY_PER_MONTH")
    private String salaryPerMonth;

    @Column(name = "SAVED_MONEY")
    private String savedMoney;

    @Column(name = "SUBMIT_DATE")
    private Date submitDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFER_REQUEST_ID")
    @MapTo(targetEntity = OfferDTO.class)
    private List<OfferEntity> offers;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    @MapTo(targetEntity = ProfileDTO.class)
    private ProfileEntity profile;*/

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFER_REQ_ID")
    @MapTo(targetEntity = UserDTO.class)
    private UserEntity user;*/

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(String salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public String getSavedMoney() {
        return savedMoney;
    }

    public void setSavedMoney(String savedMoney) {
        this.savedMoney = savedMoney;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferEntity> offers) {
        this.offers = offers;
    }

/*    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }*/

/*    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }*/
}
