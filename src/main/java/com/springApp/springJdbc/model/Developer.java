package com.springApp.springJdbc.model;

/**
 * Model
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Developer {

    private Integer id;
    private String name;
    private String speciality;
    private Integer experience;

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Developer:" + "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Speciality: " + speciality + "\n" +
                "Experience: " + experience + "\n";
    }
}
