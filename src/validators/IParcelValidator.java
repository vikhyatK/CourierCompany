package validators;

import exceptions.ParcelValidationException;
import models.Parcel;

public interface IParcelValidator {

	public void validateParcel(Parcel parcel) throws ParcelValidationException;
}
