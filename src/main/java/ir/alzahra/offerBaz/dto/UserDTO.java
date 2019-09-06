package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.enums.CustomerType;
import ir.alzahra.offerBaz.enums.Gender;
import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.OfferRequestEntity;
import ir.alzahra.offerBaz.model.entity.ProfileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class UserDTO extends BaseDto {

    private Long id;
    private String name;
    private String family;
    private String age;
    private Gender gender;
    @MapTo(targetEntity = ProfileEntity.class)
    private ProfileDTO profile;
    private String email;
    private String phoneNumber;
    private CustomerType customerType;

    public UserDTO() {
    }

    public UserDTO(ProfileDTO profile) {
        this.profile = profile;
    }

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

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
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
}
