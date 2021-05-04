package co.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.store.app.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

}
