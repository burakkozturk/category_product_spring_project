package Ecommerce.project.business.response.subCategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubCategoryResponse {
    private int id;
    private String name;
    private String categoryName;
}
