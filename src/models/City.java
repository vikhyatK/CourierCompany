package models;

public class City {

	private String name;
	private int firstHalfCharges;
	private int secondHalfCharges;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFirstHalfCharges() {
		return firstHalfCharges;
	}
	public void setFirstHalfCharges(int firstHalfCharges) {
		this.firstHalfCharges = firstHalfCharges;
	}
	public int getSecondHalfCharges() {
		return secondHalfCharges;
	}
	public void setSecondHalfCharges(int secondHalfCharges) {
		this.secondHalfCharges = secondHalfCharges;
	}
}
