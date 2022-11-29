package in.ac.iiitb.domaincatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DomainCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainCatalogApplication.class, args);
    }

}
