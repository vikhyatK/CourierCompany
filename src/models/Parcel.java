package models;

import exceptions.ParcelValidationException;

public class Parcel {

	private int actualWeight;
	private int effectiveWeight;
	private boolean fragile;

	public Parcel(int actualWeight, boolean fragile) throws ParcelValidationException {
		if (actualWeight <= 0 || actualWeight > 5000)
			throw new ParcelValidationException("Parcel wheight should range from 1gm to 5000gm");
		this.actualWeight = actualWeight;
		this.effectiveWeight = ((actualWeight + 99) / 100) * 100;
		this.fragile = fragile;
	}

	public int getActualWeight() {
		return actualWeight;
	}
	public void setActualWeight(int actualWeight) {
		this.actualWeight = actualWeight;
	}
	public int getEffectiveWeight() {
		return effectiveWeight;
	}
	public void setEffectiveWeight(int effectiveWeight) {
		this.effectiveWeight = effectiveWeight;
	}
	public boolean isFragile() {
		return fragile;
	}
	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}
}
