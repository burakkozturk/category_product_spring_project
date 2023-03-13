package Ecommerce.project.business.response.categoryResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCategoryResponse {
    private int id;
    private String name;
}
