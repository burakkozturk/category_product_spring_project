package Ecommerce.project.business.response.productResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductResponse {
    private int id;
    private String name;
    private String subCategoryName;
}
