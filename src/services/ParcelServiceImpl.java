package services;

import java.util.List;

import models.Order;
import validators.IOrderValidator;
import validators.OrderValidator;

public class ParcelServiceImpl implements IParcelService {
	IOrderValidator orderValidator = new OrderValidator();

	@Override
	public String submitOrders(List<Order> orderList) {
		for(Order order : orderList) {
			orderValidator.validateOrder(order);
		}
		return null;
	}

}
