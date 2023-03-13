package Ecommerce.project.business.concrete;

import Ecommerce.project.business.abstracts.CategoryService;
import Ecommerce.project.business.request.categoryRequest.CreateCategoryRequest;
import Ecommerce.project.business.request.categoryRequest.UpdateCategoryRequest;
import Ecommerce.project.business.response.categoryResponse.GetAllCategoryResponse;
import Ecommerce.project.business.response.categoryResponse.GetByIdCategoryResponse;
import Ecommerce.project.core.utilities.mappers.ModelMapperService;
import Ecommerce.project.dataAccess.abstracts.CategoryRepository;
import Ecommerce.project.entities.concrete.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();

        List<GetAllCategoryResponse> categoryResponses = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());

        return categoryResponses;
    }

    @Override
    public GetByIdCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetByIdCategoryResponse response = this.modelMapperService.forResponse()
                .map(category, GetByIdCategoryResponse.class);

        return response;
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = this.modelMapperService.forRequest()
                .map(updateCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }
}
