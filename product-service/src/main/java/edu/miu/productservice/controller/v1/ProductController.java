package edu.miu.productservice.controller.v1;

import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;
import edu.miu.productservice.entity.Product;
import edu.miu.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO dto = productService.addProduct(productRequestDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{productnumber}")
    ResponseEntity<?> getProduct(@PathVariable String productnumber) {
        ProductResponseDTO dto = productService.getProduct(productnumber);
        if (dto != null) {
            return new ResponseEntity<>(productService.getProduct(productnumber), HttpStatus.OK);
        }
        return new ResponseEntity<>("product with this product number " + productnumber + " couldn't find", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productnumber}")
    ResponseEntity<?> deleteProduct(@PathVariable String productnumber) {
        ProductResponseDTO deleteProduct = productService.deleteProduct(productnumber);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

    @PutMapping("/{productnumber}")
    ResponseEntity<?> updateProduct(@PathVariable String productnumber, @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO responseDTO = productService.updateProduct(productnumber, productRequestDTO);

        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("product with this product number " + productnumber + " couldn't find", HttpStatus.NO_CONTENT);

    }

}
