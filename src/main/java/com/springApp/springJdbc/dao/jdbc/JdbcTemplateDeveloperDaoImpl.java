package com.springApp.springJdbc.dao.jdbc;

import com.springApp.springJdbc.dao.DeveloperDao;
import com.springApp.springJdbc.model.Developer;
import com.springApp.springJdbc.util.DeveloperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * Using JdbcTemplate for DAO
 * @author Ihor Savchenko
 * @version 1.0
 */
public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    public void createDeveloper(String name, String speciality, Integer experience) {
        String SQL = "INSERT INTO DEVELOPERS (name, speciality, experience) VALUES (?,?,?)";

        jdbcTemplate.update(SQL, name, speciality, experience);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpeciality: " +
                speciality + ";\nExperience: " + experience + "\n");
    }

    public Developer getDeveloperById(Integer id) {
        String SQL = "SELECT * FROM DEVELOPERS WHERE id = ?";
        Developer developer = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DeveloperMapper());
        return developer;
    }

    public List<Developer> listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        List<Developer> developers = jdbcTemplate.query(SQL, new DeveloperMapper());
        return developers;
    }

    public void removeDeveloper(Integer id) {
        String SQL = "DELETE FROM DEVELOPERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Developer with id: " + id + " successfully removed");
    }

    public void updateDeveloper(Integer id, String name, String speciality, Integer experience) {
        String SQL = "UPDATE DEVELOPERS SET name = ?, speciality = ?, experience = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, speciality, experience, id);
        System.out.println("Developer with id: " + id + " successfully updated.");
    }
}
