package tp4.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



import tp4.model.db.DBConnection;
import tp4.model.vo.Bill;



public class BillDao {
	
	//bill表的添加
	public int Inserservlet(Bill bill)
	{
		Connection con = DBConnection.getConnection();
		String sql="insert into bill values(?,?,?,?)";
		Date date =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		String now1 = sdf1.format(date);
		PreparedStatement pre = null;
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1,"out"+now);
			pre.setFloat(2,bill.getBill_amount());
			pre.setString(3, now1);
			pre.setString(4, bill.getComment());
			int i = pre.executeUpdate();
			if(i>0)
			{
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	//bill表的删除，根据bill_id
	public int deleteBillById(String billId) {

		Connection con = DBConnection.getConnection();
		String sql = "delete from bill where bill_id = ?";
		PreparedStatement pre = null;
		try {
			pre =  con.prepareStatement(sql);
			pre.setString(1, billId);
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	//bill表的修改
	public int updateBill(Bill bill)
	{
		Connection con = DBConnection.getConnection();
		String sql ="update person set bill_amount=?,comment=? where bill_id= ? ";
		PreparedStatement pre = null;
		try {
			pre =con.prepareStatement(sql);
			pre.setString(1, bill.getBill_id());
			pre.setFloat(2,bill.getBill_amount());
			pre.setString(3, bill.getComment());
			
			int i = pre.executeUpdate();
			if(i>0)
			{
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//bill表的全查询
	public ArrayList<Bill> FinBillAll() {

		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		String sql = "select * from bill";
		try {
			 pre = con.prepareStatement(sql);
			 res = pre.executeQuery();
			ArrayList<Bill> list = new ArrayList<Bill>();
			while (res.next()) {
				
				Bill user = new Bill(res.getString("bill_id"),res.getFloat("bill_amount"),res.getString("bill_time"),res.getString("comment"));
				list.add(user);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	//bill表根据id查询 0 
	public Bill findBillById(String billid){
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet res =null;
		String sql="select * from bill where bill_id=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, billid);
		    res = pre.executeQuery();
			if(res.next())
			{
				Bill bill = new Bill(res.getString("bill_id"),res.getFloat("bill_amount"),res.getString("bill_time"),res.getString("comment"));
				return bill;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}
