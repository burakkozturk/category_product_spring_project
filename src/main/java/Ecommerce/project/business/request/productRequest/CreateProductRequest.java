package Ecommerce.project.business.request.productRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotNull
    private String name;
    @NotNull
    private int subCategoryId;
}
