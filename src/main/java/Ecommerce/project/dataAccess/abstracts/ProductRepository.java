package Ecommerce.project.dataAccess.abstracts;

import Ecommerce.project.entities.concrete.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
