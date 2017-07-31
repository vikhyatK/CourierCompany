import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceptions.ParcelValidationException;
import junit.framework.TestCase;
import models.Order;
import models.Parcel;
import services.IParcelService;
import services.ParcelServiceImpl;

public class ParcelServiceTest extends TestCase {

	IParcelService parcelService = new ParcelServiceImpl();

	/**
	 * Test with only one parcel in an order.
	 * Destination = Bangalore
	 * Fragile = true
	 * Parcels = 1
	 * Total charge should be 80 or 86
	 */
	@Test
	public void testSubmissionOfValidOrderWithSingleParcel() {
		Parcel parcel1 = new Parcel();
		parcel1.setActualWeight(76);
		parcel1.setFragile(true);
		Order ord1 = new Order(parcel1, "Bangalore");

		List<Order> orderList = new ArrayList<>();
		orderList.add(ord1);
		try {
			assertTrue(parcelService.submitOrders(orderList));
			assertTrue(orderList.get(0).getTotalCharges() != 0.0);
			assertTrue(orderList.get(0).getTotalCharges() == 80.0 || orderList.get(0).getTotalCharges() == 86.0);
		} catch (ParcelValidationException e) {
			fail("The test should not have thrown exception");
			e.printStackTrace();
		}
	}

	/**
	 * Test with submission of valid number of Parcel in an Order.
	 * Destination = Bangalore
	 * Fragile = true
	 * Parcels = 3
	 * Total charge should be 80.0 * 3 = 240 or 86.0 * 3 = 258
	 */
	@Test
	public void testSubmissionOfValidOrderWithMultipleParcels() {
		Order ord = new Order("Bangalore");
		for (int i = 0; i <= 2; i++) {
			Parcel parcel = new Parcel();
			parcel.setActualWeight(76);
			parcel.setFragile(true);
			try {
				ord.addParcel(parcel);
			} catch (ParcelValidationException e) {
				fail("The test should not have thrown exception");
				e.printStackTrace();
			}
		}
		List<Order> orderList = new ArrayList<>();
		orderList.add(ord);
		try {
			assertTrue(parcelService.submitOrders(orderList));
			assertTrue(orderList.get(0).getTotalCharges() != 0.0);
			// Charges for multiple charges are calculated separately
			assertTrue(orderList.get(0).getTotalCharges() == 240.0 || orderList.get(0).getTotalCharges() == 258.0);
		} catch (ParcelValidationException e) {
			fail("The test should not have thrown exception");
			e.printStackTrace();
		}
	}

	/**
	 * Test with more than 3 parcels in an order Test an expects an exception
	 */
	@Test
	public void testSubmissionOfValidOrderWithInvalidNumberOfParcels() {
		Order ord = new Order("Bangalore");
		for (int i = 0; i <= 3; i++) {
			Parcel parcel = new Parcel();
			parcel.setActualWeight(76);
			parcel.setFragile(true);
			try {
				ord.addParcel(parcel);
				if (i == 3) {
					fail("The test should have thrown exception");
				}
			} catch (ParcelValidationException e) {
				assertEquals("Test failed as the reason of error message is unexpected",
						"Maximum of 3 parcels allowed per order", e.getMessage());
			}
		}
	}

	/**
	 * Test with null destination Destination = null
	 */
	@Test
	public void testSubmissionOfInValidOrderWithValidNumberOfParcels() {
		Order ord = new Order(null);
		for (int i = 0; i <= 2; i++) {
			Parcel parcel = new Parcel();
			parcel.setActualWeight(76);
			parcel.setFragile(true);
			try {
				ord.addParcel(parcel);
			} catch (ParcelValidationException e) {
				fail("The test should not have thrown exception");
				e.printStackTrace();
			}
		}
		List<Order> orderList = new ArrayList<>();
		orderList.add(ord);
		try {
			assertTrue(parcelService.submitOrders(orderList));
			fail("The test should have thrown exception");
		} catch (ParcelValidationException e) {
			assertEquals("Test failed as the reason of error message is unexpected", "Destination cannot be null",
					e.getMessage());
		}
	}

	/**
	 * Test submits 51 parcels in 51 orders. The total charges should be For first
	 * half : 50 * 80 = 4000 For second half : 1 * 86 = 86 So total charges should
	 * be 4086
	 */
	@Test
	public void testSubmissionOfFiftyOneParcels() {
		List<Order> orderList = new ArrayList<>();
		for (int i = 1; i <= 51; i++) {
			Order ord = new Order("Bangalore");
			Parcel parcel = new Parcel();
			parcel.setActualWeight(76);
			parcel.setFragile(true);
			try {
				ord.addParcel(parcel);
			} catch (ParcelValidationException e) {
				fail("The test should not have thrown exception");
				e.printStackTrace();
			}
			orderList.add(ord);
		}
		try {
			assertTrue(parcelService.submitOrders(orderList));
			double allOrderCharges = 0.0;
			for (Order order : orderList) {
				allOrderCharges = allOrderCharges + order.getTotalCharges();
			}
			assertTrue(allOrderCharges != 0.0);
			// Charges include second half charges
			assertTrue(allOrderCharges == 4086.0);
		} catch (ParcelValidationException e) {
			fail("The test should not have thrown exception");
		}
	}

}
