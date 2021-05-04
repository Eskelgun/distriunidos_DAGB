package co.store.app.service;

import java.util.List;
import java.util.Optional;

import co.store.app.domain.PaymentMethod;

public interface PaymentMethodService {

	/* CONSULTAR */

	/**
	 * Consulta todos los metodos de pagos
	 * 
	 * @return List<PaymentMethod>
	 * @throws Exception
	 */
	public List<PaymentMethod> consultarMetodosPago() throws Exception;

	/**
	 * Consulta los metodos de pago según un estado
	 * 
	 * @param estado
	 * @return List<PaymentMethod>
	 * @throws Exception
	 */
	public List<PaymentMethod> consultarPorEstado(String estado) throws Exception;

	/* BUSCAR */

	/**
	 * 
	 * @param id
	 * @return Optional<PaymentMethod>
	 * @throws Exception
	 */
	public Optional<PaymentMethod> buscarPorId(int id) throws Exception;

	/* GUARDAR */
	/**
	 * Guarda un metodo de pago
	 * 
	 * @param paymentMethod
	 * @throws Exception
	 */
	public void guardarMetodoPago(PaymentMethod paymentMethod) throws Exception;

	/* ACTUALIZAR */
	/**
	 * Actualiza un metodo de pago
	 * 
	 * @param paymentMethod
	 * @throws Exception
	 */
	public void actualizarMetodoPago(PaymentMethod paymentMethod) throws Exception;

	/* ELIMINAR */
	/**
	 * Elimina un Metodo de pago
	 * 
	 * @param paymentMethod
	 * @throws Exception
	 */
	public void eliminarMetodoPago(PaymentMethod paymentMethod) throws Exception;


}// END CLASS
