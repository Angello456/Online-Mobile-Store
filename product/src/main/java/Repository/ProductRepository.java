package Repository;

import org.springframework.data.repository.CrudRepository;
import Entity.Product;

public interface ProductRepository extends CrudRepository<Product, String>{

}
