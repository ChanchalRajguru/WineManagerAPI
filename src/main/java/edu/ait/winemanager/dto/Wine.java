package edu.ait.winemanager.dto;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int year;
    private String grapes;
    private String country;
    private String region;

    @Column(name="description",columnDefinition="blob")
    private String description;

    private String picture;


    public Wine() {
    }

    public Wine(Integer id, String name, int year, String grapes, String country, String region, String description, String picture) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.grapes = grapes;
        this.country = country;
        this.region = region;
        this.description = description;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGrapes() {
        return grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", grapes='" + grapes + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
