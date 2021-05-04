package co.store.app.service;

import java.util.List;
import java.util.Optional;

import co.store.app.domain.Product;

public interface ProductService {

	/* CONSULTAR */

	/**
	 * Consulta todos los Productos
	 * 
	 * @return List<PaymentMethod>
	 * @throws Exception
	 */
	public List<Product> consultarProductos() throws Exception;

	/**
	 * Consulta los Productos según un estado
	 * 
	 * @param estado
	 * @return List<Product>
	 * @throws Exception
	 */
	public List<Product> consultarPorEstado(String estado) throws Exception;

	/* BUSCAR */

	/**
	 * 
	 * @param id
	 * @return Optional<Product>
	 * @throws Exception
	 */
	public Optional<Product> buscarPorId(int id) throws Exception;

	/* GUARDAR */
	/**
	 * Guarda un metodo de pago
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void guardarProductos(Product product) throws Exception;

	/* ACTUALIZAR */
	/**
	 * Actualiza un Producto
	 * 
	 * @param paymentMethod
	 * @throws Exception
	 */
	public void actualizarProductos(Product product) throws Exception;

	/* ELIMINAR */
	/**
	 * Elimina un Producto
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void eliminarProducto(Product product) throws Exception;


}
