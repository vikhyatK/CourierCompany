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
	
	@Test
	public void testOrderSubmission() throws ParcelValidationException {
		Parcel parcel1 = new Parcel();
		parcel1.setActualWeight(76);
		parcel1.setFragile(true);
		Order ord1 = new Order(parcel1, "Bangalore");
		
		List<Order> orderList = new ArrayList<>();
		orderList.add(ord1);
		assertTrue(parcelService.submitOrders(orderList));
	}

}
