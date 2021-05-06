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
	public List<Product> findByEnableOrderByName(@Param("enable") String estado);

	/**
	 * select * from product where name = ?
	 * 
	 * @param nombre
	 * @return List<Product>
	 */
	public List<Product> findByNameOrderByName(@Param("name") String nombre);

	/**
	 * select * from product where name = LIKE(?)
	 * 
	 * @param nombre
	 * @return List<Product>
	 */
	public List<Product> findByNameContainingOrderByName(@Param("name") String nombre);

	/**
	 * select * from product where price <= ?
	 * 
	 * @param precio
	 * @return List<Product>
	 */
	public List<Product> findByPriceLessThanEqualOrderByPrice(@Param("price") float precio);

	/**
	 * select * from product where price => ?
	 * 
	 * @param precio
	 * @return List<Product>
	 */
	public List<Product> findByPriceGreaterThanEqualOrderByPrice(@Param("price") float precio);

}
