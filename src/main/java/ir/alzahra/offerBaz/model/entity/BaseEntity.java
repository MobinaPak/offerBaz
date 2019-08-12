package ir.alzahra.offerBaz.model.entity;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RevisionNumber;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/21/2019, Sun
 **/
@MappedSuperclass
@Audited(withModifiedFlag = false)
public abstract class BaseEntity implements Serializable {


    @Column(name = "CREATED_BY", length = 40)
    private String createdBy;

    @Column(name = "UPDATED_BY", length = 40)
    private String updatedBy;


    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
//    @RevisionTimestamp
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
//    @RevisionTimestamp
    private Date updatedAt;

    @Version
    @Column(name="VERSION", nullable = false)
    @RevisionNumber
    private Long version;

    @Transient
    private Boolean isHandled = false;

    /**
     * Gets created by.
     *
     * @return the created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets created by.
     *
     * @param createdBy the created by
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets updated by.
     *
     * @return the updated by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets updated by.
     *
     * @param updatedBy the updated by
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets version.
     *
     * @param version the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Gets is handled.
     *
     * @return the is handled
     */
    public Boolean getIsHandled() {
        return isHandled;
    }

    /**
     * Sets is handled.
     *
     * @param isHandled the is handled
     */
    public void setIsHandled(final Boolean isHandled) {
        this.isHandled = isHandled;
    }

    /**
     * Gets replacement for.
     *
     * @return the replacement for
     */


    /**
     * Sets replacement for.
     *
     * @param replacementFor the replacement for
     */

    /**
     * Sets creation by at.
     */
    /*@PrePersist
    public void setCreationByAt() {
        ProfileDto user = (ProfileDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.createdBy = user.getUserName();
        this.createdAt = new Date();
    }

    *//**
     * Sets change by at.
     *//*
    @PreUpdate
    public void setChangeByAt() {
        ProfileDto user = (ProfileDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.updatedBy = user.getUserName();
        this.updatedAt = new Date();
    }*/

}

