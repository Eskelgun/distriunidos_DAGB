package co.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.store.app.domain.ShoppingProduct;
import co.store.app.repository.ShoppingProductRepository;

@Service
public class ShoppingProductServiceImpl implements ShoppingProductService {
	
	@Autowired
	private ShoppingProductRepository shoppingProductRepository;

	/* GUARDAR */
//	Guarda un nuevo producto a comprar
	@Override
	public void guardarShoppingProduct(ShoppingProduct shoppingProduct) throws Exception {

		if (shoppingProduct == null) {
			throw new Exception("El producto a comprar no existe");
		}

//		Cantidad
		if (shoppingProduct.getQuantity() < 0) {
			throw new Exception("El producto no puede tener cantidad negativa");
		}

//		Total
		if (shoppingProduct.getTotal() < 0) {
			throw new Exception("El producto no puede tener valor negativo");
		}

		// Guardamos el producto a comprar.
		shoppingProductRepository.save(shoppingProduct);

	}

}
