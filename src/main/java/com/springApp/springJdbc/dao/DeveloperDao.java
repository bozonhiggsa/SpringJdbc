package com.springApp.springJdbc.dao;


import com.springApp.springJdbc.model.Developer;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * Interface DAO
 * @author Ihor Savchenko
 * @version 1.0
 */
public interface DeveloperDao {

    /*void setJdbcTemplate(JdbcTemplate jdbcTemplate);*/

    void createDeveloper(String name, String specialty, Integer experience);

    Developer getDeveloperById(Integer id);

    List<Developer> listDevelopers();

    void removeDeveloper(Integer id);

    void updateDeveloper(Integer id, String name, String specialty, Integer experience);
}
