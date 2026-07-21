package week5.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Cloud API Gateway serving as the single entry point for all frontend traffic.
 * It uses WebFlux (Netty) for non-blocking, high-throughput routing.
 * @EnableDiscoveryClient allows the gateway to fetch route locations from Eureka Server.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
        System.out.println("=========================================================");
        System.out.println("🚀 API Gateway started on port 8080");
        System.out.println("📡 Routing traffic via Eureka LoadBalancer (lb://)");
        System.out.println("=========================================================");
    }
}
