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
        return new ResponseEntity<ProductResponseDTO>(productResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{productNumber}")
    ResponseEntity<?> getProduct(@PathVariable String productNumber) {
        ProductResponseDTO productResponseDTO = productService.getProduct(productNumber);
        if (productResponseDTO != null) {
            return new ResponseEntity<>(productService.getProduct(productNumber), HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find product with the product number: " + productNumber,
                HttpStatus.NO_CONTENT);
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
