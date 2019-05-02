package ir.alzahra.offerBaz.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@Entity
@Table(name="PROFILE")
public class ProfileEntity extends BaseEntity {

    private static final long serialVersionUID = 7323957813318349601L;

    @Id
    @Column(name = "USERNAME", unique = true,nullable = false, length = 45)
    private String userName;

    @Column(name = "PASSWORD",nullable = false, length = 60)
    private String password;

    @Column(name = "ENABLE", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    private Set<ProfileRoleEntity> profileRoles = new HashSet<ProfileRoleEntity>(0);

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    private List<OfferRequestEntity> offerRequests;

    public ProfileEntity() {
    }

    public ProfileEntity(String username, String password, boolean enabled) {
        this.userName = username;
        this.password = password;
        this.enabled = enabled;
    }

    public ProfileEntity(String username, String password,
                         boolean enabled, Set<ProfileRoleEntity> userRole) {
        this.userName = username;
        this.password = password;
        this.enabled = enabled;
        this.profileRoles = userRole;
    }

    public Set<ProfileRoleEntity> getUserRole() {
        return this.profileRoles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public boolean isEnabled() {
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
