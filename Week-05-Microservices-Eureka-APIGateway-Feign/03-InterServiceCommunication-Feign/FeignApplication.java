package week5.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot Application demonstrating Feign capabilities.
 * @EnableFeignClients scans for interfaces annotated with @FeignClient and generates proxy implementations.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "week5.feign.client")
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
        System.out.println("=========================================================");
        System.out.println("🚀 Feign Client Application started.");
        System.out.println("🔌 Ready to make declarative REST calls to other services.");
        System.out.println("=========================================================");
    }
}
