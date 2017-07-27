package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParcelValidationException;

public class Order {

	private List<Parcel> parcelList = new ArrayList<>();
	private City destination;
	
	public Order(Parcel parcel, City destination) {
		this.destination = destination;
		this.parcelList.add(parcel);
	}

	public List<Parcel> getParcelList() {
		return parcelList;
	}

	public void addParcel(Parcel parcel) throws ParcelValidationException {
		if(this.parcelList.size() <= 3) {
			parcelList.add(parcel);
		} else {
			throw new ParcelValidationException("Not more than 3 parcels allowed per order");
		}
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}
}
