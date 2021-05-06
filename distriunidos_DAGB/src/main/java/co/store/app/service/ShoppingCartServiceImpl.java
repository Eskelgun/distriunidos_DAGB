package co.store.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.store.app.domain.ShoppingCart;
import co.store.app.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	/* BUSCAR */
//	Busca un carro por el id
	@Override
	public Optional<ShoppingCart> buscarShoppingCartById(int idCar) throws Exception {

		if (idCar <= 0) {
			throw new Exception("El id del carro no puede ser inferior a 1");
		}

		Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(idCar);

		return shoppingCart;
	}

	/* GUARDAR */
//	Guarda un carro de compra
	@Override
	public void guardarShoppingCart(ShoppingCart shoppingCart) throws Exception {

		if (shoppingCart == null) {
			throw new Exception("El carro de compra no existe");
		}

//		total
		if (shoppingCart.getTotal() < 0) {
			throw new Exception("El total no puede ser inferior a 0");
		}

//		items
		if (shoppingCart.getItems() < 0) {
			throw new Exception("El total de items no puede ser inferior a 0");
		}

//		estado
		if (shoppingCart.getEnable() == null || shoppingCart.getEnable().trim().equals(" ")) {
			throw new Exception("El estado no puede ser invalido");
		}

//		Guardamos el carro de compras
		shoppingCartRepository.save(shoppingCart);

	}

}
