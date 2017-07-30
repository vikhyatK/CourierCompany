package services;

import exceptions.ParcelValidationException;
import models.Order;

public interface IParcelDispatcherService {

	public void dispatchOrder(Order order) throws ParcelValidationException;

}
