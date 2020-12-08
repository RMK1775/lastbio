package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class AdCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Ad> ads;

    public AdCategory() {
    }

//Read
    public AdCategory(long anId, String aName, List<Ad> ads) {
        this.id = anId;
        this.name = aName;
        this.ads = ads;
    }

//Create
    public AdCategory(String aName, List<Ad> ads) {
        this.name = aName;
        this.ads = ads;
    }

//Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
}
