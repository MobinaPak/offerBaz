package ir.alzahra.offerBaz.model.entity;

import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.facade.mapper.MapTo;

import javax.persistence.*;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/

@Entity
@Table(name = "PROFILE_ROLE",
        uniqueConstraints = @UniqueConstraint(
                columnNames = { "ROLE", "PROFILE_ID" }))
public class ProfileRoleEntity extends BaseEntity {

//    private static final long serialVersionUID = 5521703395679440177L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID")
    @MapTo(targetEntity = ProfileDTO.class)
    private ProfileEntity profile;*/

    @Column(name = "ROLE", nullable = false, length = 45)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }*/

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

