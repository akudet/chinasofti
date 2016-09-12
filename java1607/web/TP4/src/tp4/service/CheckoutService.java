package tp4.service;

import java.util.Date;
import java.util.List;

import tp4.model.vo.Checkin;
import tp4.model.vo.Checkout;
import tp4.model.vo.Room;

/**
 * 
 * @author 项双江
 * 
 */
public class CheckoutService {
	// 参考 2.4 客户结账, 2.6 营业查询

	/**
	 * 办理结帐
	 * 
	 * @param room
	 *            结帐房间
	 * @param amount
	 *            实收金额个
	 * @param res
	 *            找零, 如果结帐成功,则在末尾添加找零,否则不作修改
	 * @return 执行结果 0 表示成功
	 */
	public int checkout(Room room, float amount, List<Float> res) {
		return -1;
	}

	public List<Checkout> find() {
		return null;
	}

	public List<Checkout> find(Date start, Date end, String checkType,
			List<String> roomType) {
		return null;
	}

	public List<Checkout> find(String checkType, List<String> roomType) {
		return null;
	}

	public List<Checkout> find(String name, String roomId, String status,
			String cusTypeDesc) {
		return null;
	}

	public List<Checkout> findInProcess(String name, String roomId,
			String cusTypeDesc) {
		return null;
	}

	public List<Checkout> findProcessed(String name, String roomId,
			String cusTypeDesc) {
		return null;
	}
}
