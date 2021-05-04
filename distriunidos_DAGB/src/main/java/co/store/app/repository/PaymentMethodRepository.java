package co.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.store.app.domain.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

	/**
	 * select * from payment_method where enable = ?
	 * 
	 * @param estado
	 * @return List<PaymentMethod>
	 */
	public List<PaymentMethod> findByEnableOrderByName(@Param("pEstado") String estado);

}
