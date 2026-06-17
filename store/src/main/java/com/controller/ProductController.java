package com.controller;

import com.util.exception.ProductNotFoundException;
import com.util.DTO.product.ProductCreateDTO;
import com.util.DTO.product.ProductPriceDTO;
import com.util.DTO.product.ProductSummaryDTO;
import com.util.DTO.product.ProductUpdateDTO;
import com.util.entity.Product;
import com.util.repo.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/store")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    private String sanitizeCode(String code) {
        if (code == null) {
            return null;
        }

        String trimmedCode = code.trim();
        if (trimmedCode.length() >= 10) {
            return trimmedCode;
        }

        return String.format("%10s", trimmedCode).replace(' ', '0');
    }

    @GetMapping("/product")
    public ResponseEntity<ProductPriceDTO> getByCode(@RequestParam String code){
        String sanitizedCode = sanitizeCode(code);

        Product product = repository.getByCode(sanitizedCode);

        if (product == null) {
            throw new ProductNotFoundException("Product with code " + sanitizedCode + " not found.");
        }
            return ResponseEntity.ok(new ProductPriceDTO(product.getDescription(), product.getPrice()));
    }

    @GetMapping("/products")
    public List<ProductSummaryDTO> getAll(){
        return repository.findAll().stream()
                .map(product -> new ProductSummaryDTO(product.getCode(), product.getDescription()))
                .toList();
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteByCode(@RequestBody String code){
        String sanitizedCode = sanitizeCode(code);
        int deletedCount = repository.deleteByCode(sanitizedCode);
        if (deletedCount > 0) {
            return ResponseEntity.ok("Product with code " + sanitizedCode + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Product with code " + sanitizedCode + " not found.");
        }
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductCreateDTO product){
            repository.save(new Product(sanitizeCode(product.getCode()), product.getDescription(), product.getPrice()));
            return ResponseEntity.ok("Product added successfully.");
    }

    @PutMapping("/price")
    public ResponseEntity<String> updatePrice(@Valid @RequestBody ProductUpdateDTO product) {
        String sanitizedCode = sanitizeCode(product.getCode());
        int updatedCount = repository.updatePriceByCode(sanitizedCode, product.getPrice());
        if (updatedCount > 0) {
            return ResponseEntity.ok("Price for product with code " + sanitizedCode + " updated successfully.");
        } else {
            return ResponseEntity.status(404).body("Product with code " + sanitizedCode + " not found.");
        }
    }

    @GetMapping("/itsReady")
    public ResponseEntity<String> itsReady(){
        return ResponseEntity.ok("It's ready!");
    }

    @Value("${server.instance.id}")
    String instanceId;
    @GetMapping("/instance")
    public ResponseEntity<String> getInstance() {
        return ResponseEntity.ok("Instance ID: " + instanceId);
    }

}
