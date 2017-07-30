package services;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParcelValidationException;
import models.Order;
import models.Parcel;

public class ParcelDispatcherServiceImpl implements IParcelDispatcherService {

	private IBillCalculatorService billCalulator = new BillCalculatorServiceImpl();
	private static List<Parcel> firstHalf = new ArrayList<>();
	private static List<Parcel> secondHalf = new ArrayList<>();
	private static int firstTotalWt;
	private static int secondTotalWt;

	private Object synchObj = new Object();

	@Override
	public void dispatchOrder(Order order) throws ParcelValidationException {
		List<Parcel> parcelList = order.getParcelList();
		double totalCharges = 0f;
		synchronized (synchObj) {
			for (Parcel parcel : parcelList) {
				// Total number of parcels in First Half should not exceed 50.
				// Total weight of of first half should not exceed 5kg
				if (firstHalf.size() >= 50 || firstTotalWt >= 5000
						|| (firstTotalWt + parcel.getActualWeight()) > 5000) {
					// Total number of parcels in Second Half should not exceed 50.
					// Total weight of of Second Half should not exceed 5kg
					if (secondHalf.size() >= 50 || secondTotalWt >= 5000
							|| (secondTotalWt + parcel.getActualWeight()) > 5000) {
						throw new ParcelValidationException("Queues for today are full. No more parcels");
					} else {
						secondTotalWt = secondTotalWt + parcel.getActualWeight();
						totalCharges = totalCharges
								+ billCalulator.calculateCharges(parcel, order.getDestination(), true);
					}
				} else {
					firstTotalWt = firstTotalWt + parcel.getActualWeight();
					totalCharges = totalCharges + billCalulator.calculateCharges(parcel, order.getDestination(), false);
				}
			}
		}
		order.setTotalCharges(totalCharges);
	}
}
