package services;

import java.util.List;

import exceptions.ParcelValidationException;
import models.Order;
import models.Parcel;
import validators.IOrderValidator;
import validators.IParcelValidator;
import validators.OrderValidatorImpl;
import validators.ParcelValidatorImpl;

public class ParcelServiceImpl implements IParcelService {
	IOrderValidator orderValidator = new OrderValidatorImpl();
	IParcelValidator parcelValidator = new ParcelValidatorImpl();
	IParcelDispatcherService parcelDispatcher = new ParcelDispatcherServiceImpl();

	@Override
	public boolean submitOrders(List<Order> orderList) throws ParcelValidationException {
		for (Order order : orderList) {
			orderValidator.validateOrder(order);
			for (Parcel parcel : order.getParcelList()) {
				parcelValidator.validateParcel(parcel);
			}
			parcelDispatcher.dispatchOrder(order);
		}
		return true;
	}

}
