package co.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.store.app.domain.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
