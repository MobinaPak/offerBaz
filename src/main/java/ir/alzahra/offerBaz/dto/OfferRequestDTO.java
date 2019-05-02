package ir.alzahra.offerBaz.dto;

import java.util.Date;
import java.util.List;

/**
 * @Author: zahra soltaninejad
 * @Date: 4/18/2019, Thu
 **/
public class OfferRequestDTO {

    private Long id;
    private String name;
    private String description;
    private List<OfferDTO> offerDTO;
    private String salaryPerMonth;
    private String savedMoney;
    private Date submitDate;

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

    public List<OfferDTO> getOfferDTO() {
        return offerDTO;
    }

    public void setOfferDTO(List<OfferDTO> offerDTO) {
        this.offerDTO = offerDTO;
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
}
