package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.ProfileEntity;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
public class ProfileRoleDTO extends BaseDto{

    private Long id;
/*    @MapTo(targetEntity = ProfileEntity.class)
    private ProfileDTO profile;*/
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }*/

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
