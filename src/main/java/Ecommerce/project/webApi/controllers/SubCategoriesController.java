package Ecommerce.project.webApi.controllers;

import Ecommerce.project.business.abstracts.SubCategoryService;
import Ecommerce.project.business.request.subCategoryRequest.CreateSubCategoryRequest;
import Ecommerce.project.business.request.subCategoryRequest.UpdateSubCategoryRequest;
import Ecommerce.project.business.response.subCategoryResponse.GetAllSubCategoryResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetByIdSubCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subCategories")
public class SubCategoriesController {
    private SubCategoryService subCategoryService;

    @Autowired
    public SubCategoriesController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }


    @GetMapping
    public List<GetAllSubCategoryResponse> getAll(){
        return subCategoryService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdSubCategoryResponse getById(@PathVariable int id) {
        return subCategoryService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CreateSubCategoryRequest createSubCategoryRequest){
        this.subCategoryService.add(createSubCategoryRequest);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateSubCategoryRequest updateSubCategoryRequest){
        this.subCategoryService.update(updateSubCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.subCategoryService.delete(id);
    }

}
