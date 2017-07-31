package models;

public class Parcel {

	private int actualWeight;
	private int effectiveWeight;
	private boolean fragile;

	public int getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(int actualWeight) {
		this.actualWeight = actualWeight;
		this.effectiveWeight = ((actualWeight + 99) / 100) * 100;
	}

	public boolean isFragile() {
		return fragile;
	}

	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}

	public int getEffectiveWeight() {
		return effectiveWeight;
	}

}
