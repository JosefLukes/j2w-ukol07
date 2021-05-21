package cz.czechitas.java2webapps.ukol7.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Vizitka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 100)
    @NotEmpty
    private String celeJmeno;

    @Length(max = 100)
    @NotEmpty
    private String firma;

    @Length(max = 100)
    @NotEmpty
    private String ulice;

    @Length(max = 100)
    @NotEmpty
    private String obec;

    @Length(max = 5)
    @NotEmpty
    @Pattern(regexp="[1-8]{1}[0-9]{4}",message="PSČ má 5 číslic, pouze Česká PSČ!")
    private String psc;

    @Length(max = 100)
    @Email
    private String email;

    @Length(max = 100)
    private String telefon;

    @Length(max = 100)
    private String web;

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getCelaAdresa() {
        return ulice + ", " + psc + " " + obec  ;
    }
}
