package consumingrestapis.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse {

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("products")
    private List<Product> products;

    public ApiResponse() {
    }

    public ApiResponse(int responseCode, List<Product> products) {
        this.responseCode = responseCode;
        this.products = products;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
