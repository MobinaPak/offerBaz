package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.facade.mapper.MapTo;
import ir.alzahra.offerBaz.model.entity.ProfileEntity;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
public class ProfileRoleDTO extends BaseDto {

    private Long id;
    private String role;

    public ProfileRoleDTO() {
    }

    public ProfileRoleDTO(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
