package Ecommerce.project.business.request.subCategoryRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubCategoryRequest {
    @NotNull
    private String name;
    @NotNull
    private int categoryId;
}
