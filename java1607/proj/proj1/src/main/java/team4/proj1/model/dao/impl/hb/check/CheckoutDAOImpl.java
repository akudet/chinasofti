package team4.proj1.model.dao.impl.hb.check;

import java.util.List;

import org.springframework.stereotype.Repository;

import team4.proj1.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj1.model.dao.include.check.CheckoutDAO;
import team4.proj1.model.vo.check.Checkout;

@Repository
public class CheckoutDAOImpl extends SpringAbstractDAO<Checkout> implements
		CheckoutDAO {
	public CheckoutDAOImpl() {
		super(Checkout.class);
	}

	@Override
	public List<Checkout> findAllByCus(String name, String roomId, int status,
			String cusTypeNo) {
		return findAll("FROM Checkout WHERE name=?, roomId=?, status=?", name,
				roomId, status);
	}

	@Override
	public List<Checkout> findAllByRoom(String start, String end,
			String chargeType, List<Integer> roomTypeNos) {
		// TODO Auto-generated method stub
		return null;
	}

}
