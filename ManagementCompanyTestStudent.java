
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany co1, co2, co3, co4 ; 
	
	@Before
	public void setUp() throws Exception {
		co1= new ManagementCompany("Railey", "555555555",6);
		co2 = new ManagementCompany();
		co3 = new ManagementCompany("A", "12345", 101, 0, 0, 6, 6);
		co4 = new ManagementCompany(co1);
	}

	@After
	public void tearDown() throws Exception {
		co1=null;
		co2=null;
		co3=null;
		co4=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(co1.addProperty(sampleProperty),0,0);
		assertEquals(co1.addProperty(sampleProperty),-4,0);
		assertEquals(co3.addProperty(sampleProperty),-3,0);
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",0,0,1,1);
		assertEquals(co1.addProperty(sampleProperty),1,0);
		assertEquals(co1.addProperty(null),-2,0);
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(co1.addProperty(sampleProperty),0,0);	
		assertEquals(co1.getPropertiesCount(), 1);
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",0,0,1,1);
		assertEquals(co1.addProperty(sampleProperty),1,0);
		assertEquals(co1.getPropertiesCount(), 2);
		assertEquals(co1.addProperty(null),-2,0);
		assertEquals(co1.getPropertiesCount(), 2);
	}
	
	@Test
	public void testRemoveLastProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(co1.addProperty(sampleProperty),0,0);
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",0,0,1,1);
		assertEquals(co1.addProperty(sampleProperty),1,0);
		assertEquals(co1.getPropertiesCount(), 2);
		
		co1.removeLastProperty();
		assertEquals(co1.getPropertiesCount(), 1);
	}
	
	@Test
	public void testIsPropertiesFull() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",0,0,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),0,0);
		assertEquals(co1.isPropertiesFull(), false);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,2,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),1,0);
		assertEquals(co1.isPropertiesFull(), false);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",4,4,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),2,0);
		assertEquals(co1.isPropertiesFull(), false);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",6,6,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),3,0);
		assertEquals(co1.isPropertiesFull(), false);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",8,8,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),4,0);
		assertEquals(co1.isPropertiesFull(), true);
	}
	
	@Test
	public void testGetTotalRent() {
		sampleProperty = new Property ("Sunsational", "Beckman", 1, "BillyBob Wilson",0,0,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),0,0);
		assertEquals(co1.getTotalRent(), 1.0, 0.0);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 2, "BillyBob Wilson",2,2,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),1,0);
		assertEquals(co1.getTotalRent(), 3.0, 0.0);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 3, "BillyBob Wilson",4,4,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),2,0);
		assertEquals(co1.getTotalRent(), 6.0, 0.0);
	}
	
	@Test
	public void testHighestRentProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 1, "BillyBob Wilson",0,0,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),0,0);
		assertEquals(co1.getHighestRentPropperty(), sampleProperty);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 2, "BillyBob Wilson",2,2,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),1,0);
		assertEquals(co1.getHighestRentPropperty(), sampleProperty);
		
		sampleProperty = new Property ("Sunsational", "Beckman", 3, "BillyBob Wilson",4,4,1,1);		 
		assertEquals(co1.addProperty(sampleProperty),2,0);
		assertEquals(co1.getHighestRentPropperty(), sampleProperty);
	}
	
	@Test
	public void testIsMangementFeeValid() {
		assertEquals(co1.isMangementFeeValid(), true);
		assertEquals(co3.isMangementFeeValid(), false);
	}
	
	@Test
	public void testToString() {
		sampleProperty = new Property ("Sunsational", "Beckman", 3, "BillyBob Wilson",4,4,1,1);		 
		assertEquals(co3.addProperty(sampleProperty),0,0);
		String output = "List of the properties for A, taxID: 12345\n\nSunsational,Beckman,BillyBob Wilson,3.0\n\ntotal management fee: 3.0\n";
		assertEquals(co3.toString(), output);
	}
}
