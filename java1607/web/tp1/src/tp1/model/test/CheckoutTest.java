package tp1.model.test;

import java.util.ArrayList;

import tp1.model.dao.CheckoutDAO;
import tp1.model.vo.Checkout;

/**
 *
 * @author 田霞光
 *
 */
public class CheckoutTest {
	public static void main(String[] args) {
		
	
	  CheckoutDAO dao = new CheckoutDAO();
	  float amount = 120;
	  String comment = "qwqwqw"; 
	  Checkout checkout1 = new Checkout(amount,comment);
	  String checkout_id="2c465c0680c64b36bdaf941f6a02ceb4";
	  System.out.println(dao.add(checkout1));
	  System.out.println(dao.deleteById(checkout_id));
	  ArrayList<Checkout> checkout = dao.findAll();
	 
	  for (Checkout list : checkout) {
		  System.out.println(list.toString());
		
	  }
	  String bill_id1 = "out20160909021507";
	  System.out.println(dao.findById(bill_id1));
	  
}
	

}
