package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.OfferRequestEntity;
import ir.alzahra.offerBaz.model.entity.ProfileRoleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hanieh moafi
 * @Date: 4/19/2019
 **/
public class ProfileDTO extends BaseDto {

    private Long id;
    private String userName;
    private String password;
    private boolean enabled;
    @MapTo(targetEntity = OfferRequestEntity.class)
    private List<OfferRequestDTO> offerRequests = new ArrayList<>();
    @MapTo(targetEntity = ProfileRoleEntity.class)
    private List<ProfileRoleDTO> profileRoles = new ArrayList<>();

    public ProfileDTO() {
    }

    public ProfileDTO(String userName, String password, boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    public ProfileDTO(String userName, String password, boolean enabled, List<ProfileRoleDTO> profileRoles) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.profileRoles = profileRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<OfferRequestDTO> getOfferRequests() {
        return offerRequests;
    }

    public void setOfferRequests(List<OfferRequestDTO> offerRequests) {
        this.offerRequests = offerRequests;
    }

    public List<ProfileRoleDTO> getProfileRoles() {
        return profileRoles;
    }

    public void setProfileRoles(List<ProfileRoleDTO> profileRoles) {
        this.profileRoles = profileRoles;
    }
}
