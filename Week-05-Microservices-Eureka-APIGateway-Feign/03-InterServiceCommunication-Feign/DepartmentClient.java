package week5.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Declarative Feign Client for communicating with the Department Service.
 * 
 * Instead of hardcoding IPs or writing boilerplate RestTemplate code,
 * we just declare an interface. Spring Cloud automatically implements it at runtime.
 * 
 * @FeignClient name matches the spring.application.name of the target service in Eureka.
 */
@FeignClient(name = "DEPARTMENT-SERVICE", path = "/api/departments")
public interface DepartmentClient {

    @GetMapping("/{deptId}")
    DepartmentDTO getDepartmentById(@PathVariable("deptId") Long deptId);
    
    // Fallback/Mock DTO class just for demonstration
    public static class DepartmentDTO {
        public Long id;
        public String name;
        public String location;
    }
}
