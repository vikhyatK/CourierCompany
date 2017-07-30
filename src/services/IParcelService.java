package services;

import java.util.List;

import exceptions.ParcelValidationException;
import models.Order;

public interface IParcelService {
	// API to submit list of orders from multiple customers
	public boolean submitOrders(List<Order> orderList) throws ParcelValidationException;
}
