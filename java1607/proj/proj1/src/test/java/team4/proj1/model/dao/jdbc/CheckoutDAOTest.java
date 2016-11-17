package team4.proj1.model.dao.jdbc;

import java.util.ArrayList;

import team4.proj1.model.dao.impl.jdbc.check.CheckoutDAOImpl;
import team4.proj1.model.vo.check.Checkout;

/**
 *
 * @author 田霞光
 *
 */
public class CheckoutDAOTest {
	public static void main(String[] args) {
		
	
	  CheckoutDAOImpl dao = new CheckoutDAOImpl();
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
