package inflearn.study;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @ComponentScan + @Configuration + @EnableAutoConfiguration
@SpringBootApplication
// @Configuration
// @ComponentScan
// @EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {

        // @EnableAutoConfiguration 주석처리 후 진행한다면 -> Web Application이 아닌 상태로 구동, WEB 서버로 구동되지 않는다.
//        SpringApplication application = new SpringApplication(Application.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);

        SpringApplication.run(Application.class, args);

    }
}