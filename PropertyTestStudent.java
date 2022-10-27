
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property propertyOne, propertyTwo, propertyThree, propertyFour;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		propertyTwo = new Property();
		propertyThree = new Property("X", "Y", 2000, "Z", 5, 5, 10, 2);
		propertyFour = new Property(propertyOne);
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
		propertyTwo = null;
		propertyThree = null;
		propertyFour = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
		assertEquals("X", propertyThree.getPropertyName());
		assertEquals("", propertyTwo.getPropertyName());
		assertEquals("Property ABC", propertyFour.getPropertyName());
	}
	
	@Test
	void testOwner() {
		assertEquals("Wells Fargo Bank", propertyOne.getOwner());
		assertEquals("Z", propertyThree.getOwner());
		assertEquals("", propertyTwo.getOwner());
		assertEquals("Wells Fargo Bank", propertyFour.getOwner());
	}
	
	@Test
	void testCity() {
		assertEquals("Rockville", propertyOne.getCity());
		assertEquals("Y", propertyThree.getCity());
		assertEquals("", propertyTwo.getCity());
		assertEquals("Rockville", propertyFour.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
		assertEquals(0, propertyTwo.getRentAmount());
		assertEquals(2000.00, propertyThree.getRentAmount());
		assertEquals("Property ABC", propertyFour.getPropertyName());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
		
		assertEquals(0, propertyTwo.getPlot().getX());
		assertEquals(0, propertyTwo.getPlot().getY());
		assertEquals(1, propertyTwo.getPlot().getWidth());
		assertEquals(1, propertyTwo.getPlot().getDepth());
		
		assertEquals(5, propertyThree.getPlot().getX());
		assertEquals(5, propertyThree.getPlot().getY());
		assertEquals(10, propertyThree.getPlot().getWidth());
		assertEquals(2, propertyThree.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyOne.toString());	
		assertEquals("X,Y,Z,2000.0",propertyThree.toString());	
		assertEquals(",,,0.0",propertyTwo.toString());
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyFour.toString());
	}

}
