package validators;

import exceptions.ParcelValidationException;
import models.Order;

public class OrderValidatorImpl implements IOrderValidator {

	@Override
	public void validateOrder(Order order) throws ParcelValidationException {
		if (order.getDestination() == null)
			throw new ParcelValidationException("Destination cannot be null");
		if (order.getParcelList().isEmpty())
			throw new ParcelValidationException("Order should contain at least 1 parcel");
		// Double check the parcel list size.
		if (order.getParcelList().size() > 3)
			throw new ParcelValidationException("Maximum of 3 parcels allowed per order");
	}
}
