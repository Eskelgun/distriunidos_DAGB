package co.store.app.service;

import co.store.app.domain.ShoppingProduct;

public interface ShoppingProductService {

	/* GUARDAR */

	/**
	 * Guarda un nuevo producto a comprar con todos sus datos de entrada.
	 * 
	 * @param shoppingProduct
	 * @throws Exception
	 */

	public void guardarShoppingProduct(ShoppingProduct shoppingProduct) throws Exception;

}
