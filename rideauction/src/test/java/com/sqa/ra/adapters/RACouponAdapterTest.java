package com.sqa.ra.adapters;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sqa.ra.domain.RACoupon;

public class RACouponAdapterTest {
	
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

  @Test
  public void main() {
    throw new RuntimeException("Test not implemented");
  }
}
