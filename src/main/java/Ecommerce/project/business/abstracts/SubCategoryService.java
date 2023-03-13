package Ecommerce.project.business.abstracts;

import Ecommerce.project.business.request.categoryRequest.CreateCategoryRequest;
import Ecommerce.project.business.request.categoryRequest.UpdateCategoryRequest;
import Ecommerce.project.business.request.subCategoryRequest.CreateSubCategoryRequest;
import Ecommerce.project.business.request.subCategoryRequest.UpdateSubCategoryRequest;
import Ecommerce.project.business.response.categoryResponse.GetAllCategoryResponse;
import Ecommerce.project.business.response.categoryResponse.GetByIdCategoryResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetAllSubCategoryResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetByIdSubCategoryResponse;

import java.util.List;

public interface SubCategoryService {
    List<GetAllSubCategoryResponse> getAll();
    GetByIdSubCategoryResponse getById(int id);
    void add(CreateSubCategoryRequest createSubCategoryRequest);
    void delete(int id);
    void update(UpdateSubCategoryRequest updateSubCategoryRequest);
}
