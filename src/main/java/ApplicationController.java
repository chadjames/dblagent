import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chad on 1/11/17.
 */
@EnableAutoConfiguration
public class ApplicationController {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationController.class, args);
    }
}
