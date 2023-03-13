package Ecommerce.project.business.request.subCategoryRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSubCategoryRequest {
    private int id;
    private String name;
    private int categoryId;
}
