package tp4.model.test;

import java.util.ArrayList;

import tp4.model.dao.BillDao;
import tp4.model.vo.Bill;

/**
 *
 * @author 田霞光
 *
 */
public class BillTest {
	public static void main(String[] args) {
		
	
	  BillDao dao = new BillDao();
	  float amount = 120;
	  String comment = "qwqwqw"; 
	  Bill bill1 = new Bill(amount,comment);
	  String bill_id="2c465c0680c64b36bdaf941f6a02ceb4";
	  System.out.println(dao.Inserservlet(bill1));
	  System.out.println(dao.deleteBillById(bill_id));
	  ArrayList<Bill> bill = dao.FinBillAll();
	 
	  for (Bill list : bill) {
		  System.out.println(list.toString());
		
	  }
	  String bill_id1 = "out20160909021507";
	  System.out.println(dao.findBillById(bill_id1));
	  
}
	

}
