package com.ansi.scouting.model.data;

public class Event {
    public String campus_event;
    public String city_event;
    public String country_event;
    public String date_finish_event;
    public String date_start_event;
    public String description_event;
    public String gender;
    public String id_event;
    public String logo;
    public String municipality_event;
    public String name_event;
    public String section;

    public Event() {
    }

    public Event(String campus_event, String city_event, String country_event, String date_finish_event, String date_start_event, String description_event, String gender, String id_event, String logo, String municipality_event, String name_event, String section) {
        this.campus_event = campus_event;
        this.city_event = city_event;
        this.country_event = country_event;
        this.date_finish_event = date_finish_event;
        this.date_start_event = date_start_event;
        this.description_event = description_event;
        this.gender = gender;
        this.id_event = id_event;
        this.logo = logo;
        this.municipality_event = municipality_event;
        this.name_event = name_event;
        this.section = section;
    }

    public String getCampus_event() {
        return campus_event;
    }

    public void setCampus_event(String campus_event) {
        this.campus_event = campus_event;
    }

    public String getCity_event() {
        return city_event;
    }

    public void setCity_event(String city_event) {
        this.city_event = city_event;
    }

    public String getCountry_event() {
        return country_event;
    }

    public void setCountry_event(String country_event) {
        this.country_event = country_event;
    }

    public String getDate_finish_event() {
        return date_finish_event;
    }

    public void setDate_finish_event(String date_finish_event) {
        this.date_finish_event = date_finish_event;
    }

    public String getDate_start_event() {
        return date_start_event;
    }

    public void setDate_start_event(String date_start_event) {
        this.date_start_event = date_start_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMunicipality_event() {
        return municipality_event;
    }

    public void setMunicipality_event(String municipality_event) {
        this.municipality_event = municipality_event;
    }

    public String getName_event() {
        return name_event;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
