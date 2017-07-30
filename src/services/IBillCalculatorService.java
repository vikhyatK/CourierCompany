package services;

import exceptions.ParcelValidationException;
import models.Parcel;

public interface IBillCalculatorService {

	 public double calculateCharges(Parcel parcel, String destination, boolean secondHalf) throws ParcelValidationException;
}
