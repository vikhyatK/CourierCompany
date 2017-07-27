package models;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Parcel> parcelList = new ArrayList<>(3);
	private City destination;

	public Order() {
		
	}
	
	public Order(Parcel parcel, City destination) {
		
	}

	public List<Parcel> getParcelList() {
		return parcelList;
	}

	public void addParcel() {
		
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}
}
