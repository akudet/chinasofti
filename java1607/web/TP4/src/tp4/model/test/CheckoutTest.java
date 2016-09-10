package tp4.model.test;

import java.util.ArrayList;

import tp4.model.dao.CheckoutDao;
import tp4.model.vo.Checkout;

/**
 *
 * @author 田霞光
 *
 */
public class CheckoutTest {
	public static void main(String[] args) {
		
	
	  CheckoutDao dao = new CheckoutDao();
	  float amount = 120;
	  String comment = "qwqwqw"; 
	  Checkout checkout1 = new Checkout(amount,comment);
	  String checkout_id="2c465c0680c64b36bdaf941f6a02ceb4";
	  System.out.println(dao.Inserservlet(checkout1));
	  System.out.println(dao.deleteCheckoutById(checkout_id));
	  ArrayList<Checkout> checkout = dao.FinCheckoutAll();
	 
	  for (Checkout list : checkout) {
		  System.out.println(list.toString());
		
	  }
	  String bill_id1 = "out20160909021507";
	  System.out.println(dao.findCheckoutById(bill_id1));
	  
}
	

}
