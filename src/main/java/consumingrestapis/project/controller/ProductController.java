package consumingrestapis.project.controller;

import consumingrestapis.project.model.Category;
import consumingrestapis.project.model.Product;
import consumingrestapis.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String price,
                                        @RequestParam(required = false) String brand,
                                        @RequestParam(required = false) Category category) {

        return productService.getAllProducts(name, price, brand, category);
    }
}
