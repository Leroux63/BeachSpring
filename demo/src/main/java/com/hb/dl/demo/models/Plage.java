package com.hb.dl.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Plage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @NotBlank
    private String name;
    @Basic
    @NotBlank
    private String number;
    @Basic
    @NotEmpty(message = "Veuillez saisir une adresse valide")
    private String address;
    @Basic
    @NotBlank(message = "Veuillez saisir un code postal valide")
    private String postalCode;
    @Basic
    @NotEmpty(message = "Veuillez saisir une ville")
    private String city;
    @Basic
    private String image;

    public Plage(String name, String number, String address, String postalCode, String city, String image) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.image = image;
    }

    public Plage(String name, String number, String address, String postalCode, String city) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Plage() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        if (image == null || image.trim().isEmpty()) {
            this.image = null;
        } else {
            this.image = image;
        }
    }

}
