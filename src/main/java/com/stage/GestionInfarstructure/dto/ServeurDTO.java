package com.stage.GestionInfarstructure.dto;

public class ServeurDTO {

    private Integer id;
    private String hostName;
    private String adresseIp;
    private String status;
    private Integer categoryServeurId;
    private String specification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCategoryServeurId() {
        return categoryServeurId;
    }

    public void setCategoryServeurId(Integer categoryServeurId) {
        this.categoryServeurId = categoryServeurId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
