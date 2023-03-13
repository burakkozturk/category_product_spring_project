package Ecommerce.project.business.abstracts;

import Ecommerce.project.business.request.productRequest.CreateProductRequest;
import Ecommerce.project.business.request.subCategoryRequest.CreateSubCategoryRequest;
import Ecommerce.project.business.request.subCategoryRequest.UpdateSubCategoryRequest;
import Ecommerce.project.business.response.productResponse.GetAllProductResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetAllSubCategoryResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetByIdSubCategoryResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    void add(CreateProductRequest createProductRequest);

}
