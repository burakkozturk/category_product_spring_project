package Ecommerce.project.dataAccess.abstracts;

import Ecommerce.project.entities.concrete.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRespository extends JpaRepository<SubCategory, Integer> {
}
