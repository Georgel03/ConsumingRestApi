package consumingrestapis.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consumingrestapis.project.model.ApiResponse;
import consumingrestapis.project.model.Category;
import consumingrestapis.project.model.Product;
import consumingrestapis.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final String apiUrl = "https://automationexercise.com/api/productsList";

    @Autowired
    private ProductRepository productRepository;

    public void fetchDataAndSaveToDatabase() {
        RestTemplate restTemplate = new RestTemplate();
        String apiResponse = restTemplate.getForObject(apiUrl, String.class);

        if (apiResponse != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                ApiResponse response = objectMapper.readValue(apiResponse, ApiResponse.class);

                if (response != null && response.getResponseCode() == 200) {
                    List<Product> products = response.getProducts();
                    productRepository.saveAll(products);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }
        }
    }

    public List<Product> getAllProducts(String name, String price, String brand, Category category) {
        return productRepository.findAll()
                .stream()
                .filter(product -> name == null || product.getName().equals(name))
                .filter(product -> price == null || product.getPrice().equals(price))
                .filter(product -> brand == null || product.getBrand().equals(brand))
                .filter(product -> category == null || product.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
