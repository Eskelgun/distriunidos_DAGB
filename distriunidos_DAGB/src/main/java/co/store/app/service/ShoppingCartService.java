package co.store.app.service;

import java.util.Optional;

import co.store.app.domain.ShoppingCart;

public interface ShoppingCartService {

	/* BUSCAR */
	/**
	 * Busca un carro de compras.
	 * 
	 * @param idCar
	 * @return Optional<ShoppingCart>
	 * @throws Exception
	 */
	public Optional<ShoppingCart> buscarShoppingCartById(int idCar) throws Exception;

	/* GUARDAR */

	/**
	 * Guarda un nuevo carro.
	 * 
	 * @param shoppingCart
	 * @throws Exception
	 */

	public void guardarShoppingCart(ShoppingCart shoppingCart) throws Exception;

}
