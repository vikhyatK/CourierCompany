package services;

import java.util.List;

import models.Order;

public interface IParcelService {
	// API to submit list of orders from multiple customers
	public String submitOrders(List<Order> orderList);
}
