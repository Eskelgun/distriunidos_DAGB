package co.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.store.app.repository.ShoppingProductRepository;

@Service
public class ShoppingProductServiceImpl implements ShoppingProductService {
	
	@Autowired
	private ShoppingProductRepository shoppingProductRepository;

}
