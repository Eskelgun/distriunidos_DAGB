package co.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.store.app.domain.ShoppingProduct;

public interface ShoppingProductRepository extends JpaRepository<ShoppingProduct, Integer> {


}
