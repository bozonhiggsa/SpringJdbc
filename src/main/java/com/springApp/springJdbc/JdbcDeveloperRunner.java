package com.springApp.springJdbc;

import com.springApp.springJdbc.dao.jdbc.JdbcTemplateDeveloperDaoImpl;
import com.springApp.springJdbc.model.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Entry point
 * @author Ihor Savchenko
 * @version 1.0
 */
public class JdbcDeveloperRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("jdbc_developer_config.xml");

        JdbcTemplateDeveloperDaoImpl jdbcTemplateDeveloperDao =
                (JdbcTemplateDeveloperDaoImpl) context.getBean("jdbcTemplateDeveloperDao");

        System.out.println("========Creating new records to DB========");
        jdbcTemplateDeveloperDao.createDeveloper("Oleg", "Java Developer", 3);
        jdbcTemplateDeveloperDao.createDeveloper("Stas", "C++ Developer", 2);
        jdbcTemplateDeveloperDao.createDeveloper("Olga", "Front-end Developer", 4);

        System.out.println("========Developers List========");
        List<Developer> developers = jdbcTemplateDeveloperDao.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }

        System.out.println("========Some changes to DB========");
        jdbcTemplateDeveloperDao.updateDeveloper(3, "Olga", "JS Developer", 1);
        jdbcTemplateDeveloperDao.removeDeveloper(2);

        System.out.println("========Final Developers List========");
        List<Developer> finalDevelopers = jdbcTemplateDeveloperDao.listDevelopers();
        for (Developer developer : finalDevelopers) {
            System.out.println(developer);
        }
    }
}
