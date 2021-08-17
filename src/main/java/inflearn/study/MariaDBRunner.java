package inflearn.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

//@Component
public class MariaDBRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            connection.setAutoCommit(false);    // 트랜젝션 처리

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);

//            connection.close(); // 종료 된 후 커넥션 종료. 그 외에 catch문에 에러날 시 rollback 시키는 명령어도 있어야함
        }
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'dongmin')");
    }
}
