package co.uk.jdreamer.shoppingcart.repositories;

import co.uk.jdreamer.shoppingcart.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findById(long id);
    public List<Product> findAll();
    public void deleteById(long id);

}