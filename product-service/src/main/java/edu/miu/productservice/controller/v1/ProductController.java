package edu.miu.productservice.controller.v1;

import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;
import edu.miu.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = productService.addProduct(productRequestDTO);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{productNumber}")
    ResponseEntity<?> getProduct(@PathVariable String productNumber) {
        ProductResponseDTO productResponseDTO = productService.getProduct(productNumber);
        if (productResponseDTO != null) {
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find product with the product number: " + productNumber,
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{productNumber}")
    ResponseEntity<?> deleteProduct(@PathVariable String productNumber) {
        ProductResponseDTO deleteProduct = productService.deleteProduct(productNumber);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

    @PutMapping("/{productNumber}")
    ResponseEntity<?> updateProduct(@PathVariable String productNumber, @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO productResponseDTO = productService.updateProduct(productNumber, productRequestDTO);

        if (productResponseDTO != null) {
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("product with this product number " + productNumber + " couldn't find",
                HttpStatus.NOT_FOUND);

    }

}
