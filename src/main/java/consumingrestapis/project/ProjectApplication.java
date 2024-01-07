package consumingrestapis.project;

import consumingrestapis.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "consumingrestapis.project.model")
public class ProjectApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Call your ProductService methods here when the application starts
		productService.fetchDataAndSaveToDatabase(); // Fix the method name
		// You can add more calls if needed
	}
}
