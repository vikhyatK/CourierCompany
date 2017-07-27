package models;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Parcel> parcelList = new ArrayList<>();
	private City destination;

	public Order() {
		
	}
	
	public Order(Parcel parcel, City destination) {
		
	}

	public List<Parcel> getParcelList() {
		return parcelList;
	}

	public void addParcel(Parcel parcel) throws Exception {
		if(this.parcelList.size() <= 3) {
			parcelList.add(parcel);
		} else {
			throw new Exception("Not more than 3 parcels allowed per order");
		}
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}
}
