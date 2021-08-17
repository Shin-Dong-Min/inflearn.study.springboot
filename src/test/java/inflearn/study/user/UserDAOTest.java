package inflearn.study.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
////@RunWith(SpringRunner.class)
//@DataJpaTest
//@TestPropertySource("/application.properties")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class UserDAOTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void tt() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
    }
}