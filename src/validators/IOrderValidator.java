package validators;

import exceptions.ParcelValidationException;
import models.Order;

public interface IOrderValidator {

	public void validateOrder(Order order) throws ParcelValidationException;
}
