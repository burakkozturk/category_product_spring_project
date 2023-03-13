package Ecommerce.project.webApi.controllers;


import Ecommerce.project.business.abstracts.ProductService;
import Ecommerce.project.business.request.productRequest.CreateProductRequest;
import Ecommerce.project.business.response.productResponse.GetAllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<GetAllProductResponse> getAll(){
        return productService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CreateProductRequest createProductRequest){
        this.productService.add(createProductRequest);
    }


}
