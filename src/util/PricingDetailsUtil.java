package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import models.City;

public class PricingDetailsUtil {

	public static final Map<String, City> cityDetailsMap = new HashMap<>();
	public static final double handleWithCareCharges = 50.0;
	public static final double secondHalfPricePercentage = 0.2;

	static {
		try(BufferedReader br = new BufferedReader(new FileReader(new File(PricingDetailsUtil.class.getResource("/resources/CityDetails.txt").getFile())))){
			String line = null;
			while((line = br.readLine()) != null) {
				String[] keyVal = line.split(":");
				double firstHalfCharges = Float.valueOf(keyVal[1]);
				double secondHalfCharges = firstHalfCharges + (firstHalfCharges * secondHalfPricePercentage);
				cityDetailsMap.put(keyVal[0], new City(keyVal[0], firstHalfCharges, secondHalfCharges));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
