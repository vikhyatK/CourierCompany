package validators;

import exceptions.ParcelValidationException;
import models.Parcel;

public class ParcelValidatorImpl implements IParcelValidator {

	@Override
	public void validateParcel(Parcel parcel) throws ParcelValidationException {
		if (parcel == null)
			throw new ParcelValidationException("Parcel object cannot be empty");
		if (parcel.getActualWeight() > 5000)
			throw new ParcelValidationException("Weight of parcel cannot exceed 5kg");
	}

}
