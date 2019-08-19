package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.OfferRequestDTO;
import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.enums.CustomerType;
import ir.alzahra.offerBaz.enums.Gender;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/

@Entity
@Table(name = "USER_ENTITY")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FAMILY")
    private String family;

    @Column(name = "AGE")
    private String age;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    @MapTo(targetEntity = ProfileDTO.class)
    private ProfileEntity profile;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CUSTOMER_TYPE")
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFFER_REQ_ID")
    @MapTo(targetEntity = OfferRequestDTO.class)
    private List<OfferRequestEntity> requestDTOS;*/


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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

/*    public List<OfferRequestEntity> getRequestDTOS() {
        return requestDTOS;
    }

    public void setRequestDTOS(List<OfferRequestEntity> requestDTOS) {
        this.requestDTOS = requestDTOS;
    }*/
}
