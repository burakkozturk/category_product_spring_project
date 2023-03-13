package Ecommerce.project.dataAccess.abstracts;

import Ecommerce.project.entities.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
