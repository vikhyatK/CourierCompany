package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParcelValidationException;

public class Order {

	private static long generatedIds = 100;
	private long orderId;
	private List<Parcel> parcelList = new ArrayList<>();
	private String destination;
	private double totalCharges;
	
	public Order(Parcel parcel, String destination) {
		generatedIds++;
		orderId = generatedIds;
		this.destination = destination;
		this.parcelList.add(parcel);
	}
	
	public Order(String destination) {
		generatedIds++;
		orderId = generatedIds;
		this.destination = destination;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<Parcel> getParcelList() {
		return parcelList;
	}

	public void addParcel(Parcel parcel) throws ParcelValidationException {
		if(this.parcelList.size() < 3) {
			parcelList.add(parcel);
		} else {
			throw new ParcelValidationException("Maximum of 3 parcels allowed per order");
		}
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}

}
