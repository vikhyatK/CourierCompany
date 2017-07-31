package models;

public class City {

	private String name;
	private double firstHalfCharges;
	private double secondHalfCharges;

	public City(String name, double firstHalfCharges, double secondHalfCharges) {
		super();
		this.name = name;
		this.firstHalfCharges = firstHalfCharges;
		this.secondHalfCharges = secondHalfCharges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFirstHalfCharges() {
		return firstHalfCharges;
	}

	public void setFirstHalfCharges(double firstHalfCharges) {
		this.firstHalfCharges = firstHalfCharges;
	}

	public double getSecondHalfCharges() {
		return secondHalfCharges;
	}

	public void setSecondHalfCharges(double secondHalfCharges) {
		this.secondHalfCharges = secondHalfCharges;
	}
}
