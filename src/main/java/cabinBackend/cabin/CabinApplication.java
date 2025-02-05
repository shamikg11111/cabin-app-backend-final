package cabinBackend.cabin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"model"})  // Ensure your entities are scanned
@EnableJpaRepositories(basePackages = {"repository"})  // Ensure your repositories are scanned
public class CabinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabinApplication.class, args);
    }
}
