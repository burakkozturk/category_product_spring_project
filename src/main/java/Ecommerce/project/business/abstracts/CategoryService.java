package Ecommerce.project.business.abstracts;

import Ecommerce.project.business.request.categoryRequest.CreateCategoryRequest;
import Ecommerce.project.business.request.categoryRequest.UpdateCategoryRequest;
import Ecommerce.project.business.response.categoryResponse.GetAllCategoryResponse;
import Ecommerce.project.business.response.categoryResponse.GetByIdCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    GetByIdCategoryResponse getById(int id);
    void add(CreateCategoryRequest createCategoryRequest);
    void delete(int id);
    void update(UpdateCategoryRequest updateCategoryRequest);
}
