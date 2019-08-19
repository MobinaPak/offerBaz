package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.OfferEntity;
import ir.alzahra.offerBaz.model.entity.ProfileEntity;
import ir.alzahra.offerBaz.model.entity.UserEntity;

import java.util.Date;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class OfferRequestDTO extends BaseDto {

    private Long id;
    private String name;
    private String description;
    @MapTo(targetEntity = OfferEntity.class)
    private List<OfferDTO> offers;
    private String salaryPerMonth;
    private String savedMoney;
    private Date submitDate;
/*    @MapTo(targetEntity = ProfileEntity.class)
    private ProfileDTO profile;*/
//    @MapTo(targetEntity = UserEntity.class)
//    private UserDTO user;

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

    public List<OfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDTO> offers) {
        this.offers = offers;
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

/*    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }*/
/*
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }*/
}
