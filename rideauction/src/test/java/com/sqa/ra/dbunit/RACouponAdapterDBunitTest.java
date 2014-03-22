package com.sqa.ra.dbunit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sqa.ra.adapters.RACouponAdapter;
import com.sqa.ra.domain.RACoupon;
import com.sqa.ra.framework.RAPropertyManager;

public class RACouponAdapterDBunitTest {
static Logger logger=Logger.getLogger(RACouponAdapterDBunitTest.class);
	
    IDatabaseTester databaseTester;
    IDataSet dataSet;

    @BeforeMethod
    public void setUp() throws Exception {
        // These could come as parameters from TestNG 

        
        final String driverClass =  RAPropertyManager.getProperty("DBDriver");
        final String databaseUrl =  RAPropertyManager.getProperty("DBUrl");
        final String username = RAPropertyManager.getProperty("DBUserId");
        final String password = RAPropertyManager.getProperty("DBPassword");
     
        logger.debug("DBDriver:[" + driverClass + "],  DBUrl:[" + databaseUrl + 
        		"],  DBUserId:[" + username + "],  DBPassword:[" + 
        		((password == null) ? "UNKNOWN":"****") + "]");

        dataSet = new FlatXmlDataSet(Thread.currentThread().getContextClassLoader().getResourceAsStream("tblCoupons.xml"));
        databaseTester = new JdbcDatabaseTester(driverClass, databaseUrl, username, password);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.setTearDownOperation(DatabaseOperation.NONE);
        databaseTester.setDataSet(dataSet);

        databaseTester.onSetup();
    }
	//declare the variable of class under test
	RACouponAdapter couponAdapter=null;
	
	@BeforeMethod
	public void beforeMethod(){
		couponAdapter=new RACouponAdapter();
		
	}
	  
  @Test(expectedExceptions = RuntimeException.class)
  public void addMoreCoupon() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void applyCoupon() throws Exception {
	  RACoupon coupon=couponAdapter.getCoupon("facebook5");
	 int  coponCount=coupon.getCouponQty();
	 couponAdapter.applyCoupon("facebook5");
	 RACoupon afterApplyCoupon=couponAdapter.getCoupon("facebook5");
	 assertEquals(afterApplyCoupon.getCouponQty(), coponCount-1);
	 
  
  }

  @Test
  public void testValidCoupon() {
	  RACoupon coupon=couponAdapter.getCoupon("facebook5");
	  
	  assertNotNull(coupon);
	  assertEquals(coupon.getCouponQty(), 100);
	  
	  //add more assertions for the coupon	    
  }

  @Test
  public void isCouponValid() {
	 boolean valid= couponAdapter.isCouponValid("facebook5");
	 assertTrue(valid);
    
  }
  @Test
  public void testInvalidCoupon() {
	 boolean valid= couponAdapter.isCouponValid("fdfhshacebook5");
	 assertFalse(valid);
    
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void main() {
    throw new RuntimeException("Test not implemented");
  }
}
