package tp1.model.dao.check;

import java.util.List;

import tp1.model.dao.DAO;
import tp1.model.vo.check.Checkout;

public interface CheckoutDAO extends DAO<Checkout> {

	/**
	 * 根据相关条件查询结账单信息
	 * @param name 客户名称
	 * @param roomId 房间号
	 * @param status 当前状态(全部;消费中;已结算)
	 * @param cusTypeNo 客户类型(全部;会员;普通)
	 * @return
	 */
	public List<Checkout> findAllByCus(String name, String roomId, int status,
			String cusTypeNo);

	/**
	 * 根据相关条件查询结账单信息
	 * @param start 结账时间(起)
	 * @param end 结账时间(止)
	 * @param chargeType 计费方式
	 * @param roomTypeNos 房间类型
	 * @return
	 */
	public List<Checkout> findAllByRoom(String start, String end,
			String chargeType, List<Integer> roomTypeNos);

}
