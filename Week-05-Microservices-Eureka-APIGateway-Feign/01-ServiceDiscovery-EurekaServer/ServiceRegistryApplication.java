package week5.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring Boot Application acting as the Netflix Eureka Service Registry.
 * The @EnableEurekaServer annotation transforms this standard Boot app into a registry
 * where other microservices can publish their IP addresses and ports.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
        System.out.println("=========================================================");
        System.out.println("✅ Eureka Service Registry started on port 8761");
        System.out.println("🔗 Dashboard available at: http://localhost:8761/");
        System.out.println("=========================================================");
    }
}
