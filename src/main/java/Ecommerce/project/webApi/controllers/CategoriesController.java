package Ecommerce.project.webApi.controllers;

import Ecommerce.project.business.abstracts.CategoryService;
import Ecommerce.project.business.request.categoryRequest.CreateCategoryRequest;
import Ecommerce.project.business.request.categoryRequest.UpdateCategoryRequest;
import Ecommerce.project.business.response.categoryResponse.GetAllCategoryResponse;
import Ecommerce.project.business.response.categoryResponse.GetByIdCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<GetAllCategoryResponse> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CreateCategoryRequest createCategoryRequest){
        this.categoryService.add(createCategoryRequest);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateCategoryRequest updateCategoryRequest){
        this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.categoryService.delete(id);
    }
}
