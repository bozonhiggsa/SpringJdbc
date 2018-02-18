package com.springApp.springJdbc.util;

import com.springApp.springJdbc.model.Developer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for developer
 * @author Ihor Savchenko
 * @version 1.0
 */
public class DeveloperMapper implements RowMapper<Developer> {

    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getInt("id"));
        developer.setName(rs.getString("name"));
        developer.setSpeciality(rs.getString("speciality"));
        developer.setExperience(rs.getInt("experience"));
        return developer;
    }
}
