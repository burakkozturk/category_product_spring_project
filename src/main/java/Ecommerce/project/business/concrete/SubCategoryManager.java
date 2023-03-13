package Ecommerce.project.business.concrete;

import Ecommerce.project.business.abstracts.SubCategoryService;
import Ecommerce.project.business.request.subCategoryRequest.CreateSubCategoryRequest;
import Ecommerce.project.business.request.subCategoryRequest.UpdateSubCategoryRequest;
import Ecommerce.project.business.response.categoryResponse.GetAllCategoryResponse;
import Ecommerce.project.business.response.categoryResponse.GetByIdCategoryResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetAllSubCategoryResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetByIdSubCategoryResponse;
import Ecommerce.project.core.utilities.mappers.ModelMapperService;
import Ecommerce.project.dataAccess.abstracts.CategoryRepository;
import Ecommerce.project.dataAccess.abstracts.SubCategoryRespository;
import Ecommerce.project.entities.concrete.Category;
import Ecommerce.project.entities.concrete.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class SubCategoryManager implements SubCategoryService {

    @Autowired
    private SubCategoryRespository subCategoryRespository;

    @Autowired
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllSubCategoryResponse> getAll() {
        List<SubCategory> subCategories = subCategoryRespository.findAll();

        List<GetAllSubCategoryResponse> subCategoryResponses = subCategories.stream()
                .map(subCategory -> this.modelMapperService.forResponse()
                        .map(subCategory, GetAllSubCategoryResponse.class)).collect(Collectors.toList());

        return subCategoryResponses;
    }

    @Override
    public GetByIdSubCategoryResponse getById(int id) {
        SubCategory subCategory = subCategoryRespository.findById(id).orElseThrow();
        GetByIdSubCategoryResponse response = this.modelMapperService.forResponse()
                .map(subCategory, GetByIdSubCategoryResponse.class);

        return response;
    }

    @Override
    public void add(CreateSubCategoryRequest createSubCategoryRequest) {
        SubCategory subCategory = this.modelMapperService.forRequest().map(createSubCategoryRequest,SubCategory.class);
        this.subCategoryRespository.save(subCategory);
    }

    @Override
    public void delete(int id) {
        this.subCategoryRespository.deleteById(id);
    }

    @Override
    public void update(UpdateSubCategoryRequest updateSubCategoryRequest) {
        SubCategory subCategory = this.modelMapperService.forRequest()
                .map(updateSubCategoryRequest, SubCategory.class);
        this.subCategoryRespository.save(subCategory);
    }
}
