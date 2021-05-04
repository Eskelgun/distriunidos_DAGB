package co.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.store.app.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	/**
	 * select * from customer where enable = ?
	 * 
	 * @param estado
	 * @return List<Customer>
	 */
	public List<Customer> findByEnableOrderByName(@Param("pEstado") String estado);

	/**
	 * select * from customer where email = ?1 and token = ?2
	 * 
	 * @param estado
	 * @return List<Customer>
	 */
	public List<Customer> findByEmaildAndToken(@Param("pEmail") String email, @Param("pToken") String token);

}
