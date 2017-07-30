package services;

import exceptions.ParcelValidationException;
import models.City;
import models.Parcel;
import util.PricingDetailsUtil;

public class BillCalculatorServiceImpl implements IBillCalculatorService {

	@Override
	public double calculateCharges(Parcel parcel, String destination, boolean secondHalf) throws ParcelValidationException {
		double parcelCharges = 0.0;
		// Charges according to destination
		City city = PricingDetailsUtil.cityDetailsMap.get(destination);
		if(city == null)
			throw new ParcelValidationException("Cannot deliver to this location");
		double cityPrice = city.getFirstHalfCharges();
		// Apply second half charges
		if(secondHalf) {
			cityPrice = city.getSecondHalfCharges();
		}
		parcelCharges = (parcel.getEffectiveWeight()/100) * cityPrice;
		// Apply handle with care
		if (parcel.isFragile()) {
			parcelCharges = parcelCharges + ((parcel.getEffectiveWeight()/100) * PricingDetailsUtil.handleWithCareCharges);
		}
		return parcelCharges;
	}
}
