package com.example.jpaonetomanyopgave.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "regioner")
public class Region {
    @Id @Column(name = "r_code")
    private String kode;
    @Column(name = "r_name")
    private String navn;
    @Column(name = "r_href")
    private String href;

    // CascadeType.All part of assignment 2.
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL) @JsonBackReference
    private Set<Kommune> kommuneSet;

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

    public Set<Kommune> getKommuneSet() {
        return kommuneSet;
    }

    public void setKommuneSet(Set<Kommune> kommuneSet) {
        this.kommuneSet = kommuneSet;
    }
}
