package Ecommerce.project.business.concrete;

import Ecommerce.project.business.abstracts.ProductService;
import Ecommerce.project.business.request.productRequest.CreateProductRequest;
import Ecommerce.project.business.response.productResponse.GetAllProductResponse;
import Ecommerce.project.business.response.subCategoryResponse.GetAllSubCategoryResponse;
import Ecommerce.project.core.utilities.mappers.ModelMapperService;
import Ecommerce.project.dataAccess.abstracts.ProductRepository;
import Ecommerce.project.dataAccess.abstracts.SubCategoryRespository;
import Ecommerce.project.entities.concrete.Product;
import Ecommerce.project.entities.concrete.SubCategory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();

        List<GetAllProductResponse> productResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, GetAllProductResponse.class)).collect(Collectors.toList());

        return productResponses;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
        Product product = this.modelMapperService.forRequest().map(createProductRequest,Product.class);
        this.productRepository.save(product);
    }
}
