package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

       //GUEST

        try {
            //create guest table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE guests (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames2 = Stream.of("John Dalton", "Road Runner", "Bruce Wayne", "Charlotte Pumpernickel")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert a Guest into the database
        for (Object[] name : splitUpNames2) {
            jdbcTemplate.execute(String.format("INSERT INTO guests(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        //query the database for Guests with first name Bruce
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM guests WHERE first_name = 'Bruce'",
                        (rs, rowNum) -> new Guest(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found guest to the console
                .forEach(guest -> System.out.println(guest.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE guests;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE guests");

       //SALARIES
        try {
            jdbcTemplate.execute("CREATE TABLE salaries (id BIGINT AUTO_INCREMENT PRIMARY KEY," + "base_pay VARCHAR(255) NOT NULL,bonus VARCHAR(255) NOT NULL,business expenses VARCHAR(255) NOT NULL);");
        } catch (Exception e) {

        }

        List <Double[]> moneyNums  = List.of(new Double[]{1000d, 100d, 100d}, new Double[]{4000d, 400d, 200d});

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE employees");
    }
}
