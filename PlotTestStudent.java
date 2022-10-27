
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {
	private Plot plot1, plot2, plot3, plot4, plot5, plot6;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 8, 6);
		plot2 = new Plot(5, 4, 1, 2);
		plot3 = new Plot(1, 3, 3, 10);
		plot4 = new Plot(10, 10, 1, 1);
		plot5 = new Plot(0, 0, 4, 3);
		plot6 = new Plot(plot1);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot6));
		assertTrue(plot6.overlaps(plot1));
		assertTrue(plot1.overlaps(plot2));
		assertTrue(plot1.overlaps(plot3));
		assertTrue(plot1.overlaps(plot5));
		assertFalse(plot1.overlaps(plot4));
		assertFalse(plot2.overlaps(plot4));
		assertFalse(plot2.overlaps(plot5));
		assertFalse(plot3.overlaps(plot2));
	}
	
	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompasses(plot6));
		assertTrue(plot6.encompasses(plot1));
		assertTrue(plot1.encompasses(plot2));
		assertFalse(plot2.encompasses(plot1));
		assertFalse(plot1.encompasses(plot4));
		assertFalse(plot2.encompasses(plot4));
		assertFalse(plot2.encompasses(plot5));
		assertFalse(plot3.encompasses(plot2));
	}
	
	@Test
	public void testGetX() {
		assertEquals(2, plot1.getX());
	}
	
	@Test
	public void testGetY() {
		assertEquals(2, plot1.getY());
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(8, plot1.getWidth());
	}
	
	@Test
	public void testGetDepth() {
		assertEquals(6, plot1.getDepth());
	}
	
	@Test
	public void testToString() {
		assertEquals("0,0,4,3",plot5.toString());	
	}

}
