package co.store.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.store.app.domain.PaymentMethod;
import co.store.app.repository.PaymentMethodRepository;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

//	Consulta todos los metodos de pagos
	@Override
	public List<PaymentMethod> consultarMetodosPago() throws Exception {

		// Creamos una lista cargada con todos los metodos de pago ordenados por el
		// nombre
		List<PaymentMethod> listPaymentMethod = paymentMethodRepository.findAll(Sort.by("name"));


		if (listPaymentMethod.isEmpty()) {
			throw new Exception("No hay Productos existentes en el sistema.");
		}
		return listPaymentMethod;
	}

//	Consulta los metodos de pago según un estado
	@Override
	public List<PaymentMethod> consultarPorEstado(String estado) throws Exception {

		// Creamos una lista cargada con todos los metodos de pago según el estado
		// ordenados por el nombre
		List<PaymentMethod> listPaymentMethod = paymentMethodRepository.findByEnableOrderByName(estado);

		if (listPaymentMethod.isEmpty()) {
			throw new Exception("No hay metodos de pago existentes en el sistema con ese estado.");
		}

		return listPaymentMethod;
	}

//	Guarda un metodo de pago
	@Override
	public void guardarMetodoPago(PaymentMethod paymentMethod) throws Exception {
		
		if (paymentMethod == null) {
			throw new Exception("Metodo de pago no existe.");
		}

//		Name
		if (paymentMethod.getName() == null || paymentMethod.getName().trim().equals(" ")) {
			throw new Exception("Error en el dato NOMBRE.");

//		Enable
		}
		if (paymentMethod.getEnable() == null || paymentMethod.getEnable().trim().equals(" ")) {
			throw new Exception("Error en el dato ESTADO.");
		}

//		Guardamos el metodo de pago
		paymentMethodRepository.save(paymentMethod);

	}

//	Actualiza un metodo de pago
	@Override
	public void actualizarMetodoPago(PaymentMethod paymentMethod) throws Exception {

		if (paymentMethod == null) {
			throw new Exception("Metodo de pago no existe.");
		}

//		Name
		if (paymentMethod.getName() == null || paymentMethod.getName().trim().equals(" ")) {
			throw new Exception("Error en el dato NOMBRE.");

//		Enable
		}
		if (paymentMethod.getEnable() == null || paymentMethod.getEnable().trim().equals(" ")) {
			throw new Exception("Error en el dato ESTADO.");
		}

//		Guardamos el metodo de pago
		paymentMethodRepository.save(paymentMethod);

	}

//	Busca un metodo de pago por id
	@Override
	public Optional<PaymentMethod> buscarPorId(int id) throws Exception {
		
	if (id <= 0){
		throw new Exception("Error en el dato ID.");
	}

	Optional<PaymentMethod> paymentMethodOP = paymentMethodRepository.findById(id);

	return paymentMethodOP;
	}

	/* ELIMINAR */
	@Override
	public void eliminarMetodoPago(PaymentMethod paymentMethod) throws Exception {

		if (paymentMethod == null) {
			throw new Exception("No hay Metodos de pago existente.");
		}

		paymentMethodRepository.delete(paymentMethod);

	}

	/*
	 * // Actualiza el estado de un metodo de pago
	 * 
	 * @Override public void actualizarEstadoMetodoPago(PaymentMethod paymentMethod)
	 * throws Exception {
	 * 
	 * 
	 * }
	 */


}
