package co.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.store.app.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	/**
	 * select * from product where enable = ?
	 * 
	 * @param estado
	 * @return List<Product>
	 */
	public List<Product> findByEnableOrderByName(@Param("pEstado") String estado);

}
