package co.store.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.store.app.domain.Product;
import co.store.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

//	Consulta todos los Productos
	@Override
	public List<Product> consultarProductos() throws Exception {

		// Creamos una lista cargada con todos los productos ordenados por el nombre
		List<Product> listProductos = productRepository.findAll(Sort.by("name"));

		if (listProductos.isEmpty()) {
			throw new Exception("No hay Productos existentes en el sistema.");
		}
		return listProductos;
	}

//	Consulta los Productos según un estado
	@Override
	public List<Product> consultarPorEstado(String estado) throws Exception {

		// Creamos una lista cargada con todos los productos según el estado ordenados
		// por el nombre
		List<Product> listProductos = productRepository.findByEnableOrderByName(estado);


		if (listProductos.isEmpty()) {
			throw new Exception("No hay Productos existentes en el sistema con ese estado.");
		}
		return listProductos;
	}

//	Guarda un metodo de pago
	@Override
	public void guardarProductos(Product product) throws Exception {

		if (product == null) {
			throw new Exception("Producto no existe.");
		}

//		Detail
		if (product.getDetail() == null || product.getDetail().trim().equals(" ")) {
			throw new Exception("Error en el dato DETALLE.");
		}

//		Enable
		if (product.getEnable() == null || product.getEnable().trim().equals(" ")) {
			throw new Exception("Error en el dato ESTADO.");
		}
//		Name
		if (product.getName() == null || product.getName().trim().equals(" ")) {
			throw new Exception("Error en el dato NOMBRE.");
		}
//		Price
		if (product.getPrice() <= 0) {
			throw new Exception("Error en el dato PRECIO.");
		}

		// Guardamos el producto
		productRepository.save(product);

	}

//	Actualiza un Producto
	@Override
	public void actualizarProductos(Product product) throws Exception {

		if (product == null) {
			throw new Exception("Producto no existe.");
		}

//		Detail
		if (product.getDetail() == null || product.getDetail().trim().equals(" ")) {
			throw new Exception("Error en el dato DETALLE.");
		}

//		Enable
		if (product.getEnable() == null || product.getEnable().trim().equals(" ")) {
			throw new Exception("Error en el dato ESTADO.");
		}
//		Name
		if (product.getName() == null || product.getName().trim().equals(" ")) {
			throw new Exception("Error en el dato NOMBRE.");
		}
//		Price
		if (product.getPrice() <= 0) {
			throw new Exception("Error en el dato PRECIO.");
		}

		// Guardamos el producto
		productRepository.save(product);

	}

	/* Buscar */

	@Override
	public Optional<Product> buscarPorId(int id) throws Exception {

		if (id <= 0) {
			throw new Exception("Error en el dato ID.");
		}

		Optional<Product> productOP = productRepository.findById(id);

		return productOP;
	}

	/* ELIMINAR */
	@Override
	public void eliminarProducto(Product product) throws Exception {

		if (product == null) {
			throw new Exception("No hay producto existente.");
		}

		productRepository.delete(product);

	}

	/*
	 * // Actualiza el estado de un Producto
	 * 
	 * @Override public void actualizarEstadoProductos(Product product) throws
	 * Exception {
	 * 
	 * }
	 */

}
