package org.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products API")
public class ProductController {

    @Autowired
    ProductService productService;


    @Operation(summary = "Add a new product", description = "Create a new product and returns a created object.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Product Created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/add")
    public ResponseEntity<ProductDTOResponse> addProduct(@Valid @RequestBody ProductDTORequest product) {
        ProductDTOResponse response = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @Operation(summary = "Get a product by id", description = "Returns a product as per id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    @ApiResponse(responseCode = "404", description = "Product not found")})
    @GetMapping("/get/{id}")
    public ProductDTOResponse getProduct(@PathVariable("id") Long id) {

        return productService.getProduct(id);
    }

    @Operation(summary = "Update product", description = "Update a product and returns a updated object.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Product updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PutMapping("/{id}")
    public ProductDTOResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTORequest product) {

        return productService.updateProduct(id, product);
    }

    @Operation(summary = "Delete a product by id", description = "Delete a product as per id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")})
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

        productService.deleteProduct(id);
    }
}
