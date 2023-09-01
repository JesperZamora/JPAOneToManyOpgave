package com.example.jpaonetomanyopgave.model;

import jakarta.persistence.*;

@Entity
@Table(name = "kommuner")
public class Kommune {
    @Id @Column(name = "k_code")
    private String kode;
    @Column(name = "k_name")
    private String navn;
    @Column(name = "k_href")
    private String href;

    @ManyToOne @JoinColumn(name = "k_region_fk", referencedColumnName = "r_code")
    private Region region;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
