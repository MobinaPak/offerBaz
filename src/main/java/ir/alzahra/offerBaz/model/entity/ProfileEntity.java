package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.OfferRequestDTO;
import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.dto.ProfileRoleDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@Entity
@Table(name = "PROFILE")
public class ProfileEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME", unique = true, nullable = false, length = 45)
    private String userName;

    @Column(name = "PASSWORD", nullable = false, length = 60)
    private String password;

    @Column(name = "ENABLE", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    @MapTo(targetEntity = ProfileRoleDTO.class)
    private List<ProfileRoleEntity> profileRoles = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    @MapTo(targetEntity = OfferRequestDTO.class)
    private List<OfferRequestEntity> offerRequests;


/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @MapTo(targetEntity = UserDTO.class)
    private UserEntity user;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProfileRoleEntity> getProfileRoles() {
        return profileRoles;
    }

    public void setProfileRoles(List<ProfileRoleEntity> profileRoles) {
        this.profileRoles = profileRoles;
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

    public List<OfferRequestEntity> getOfferRequests() {
        return offerRequests;
    }

    public void setOfferRequests(List<OfferRequestEntity> offerRequests) {
        this.offerRequests = offerRequests;
    }
}
