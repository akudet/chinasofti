package team4.proj1.service;

import java.util.*;

import team4.proj1.model.dao.impl.jdbc.CusTypeDAO;
import team4.proj1.model.vo.cus.CusType;

/**
 * 
 * @author 张科林
 * 
 */
public class CusTypeService {

	// 参考 2.10 客户类型折扣
	CusTypeDAO cusTypeDao = new CusTypeDAO();
	
	//分页查询
	public List<CusType> findAll(int pageNo){
		return cusTypeDao.findAll(pageNo);
	}
	
	public int getTotalPages() {
		return cusTypeDao.getTotalPage();
	}
	
	// 添加客户类型
	public int add(int cusTypeNo, String cusTypeDesc, int discount) {
		if (discount > 1 && discount <= 10) {
			CusType cusType = new CusType(cusTypeNo, cusTypeDesc, discount);

			return cusTypeDao.add(cusType);
		}
		return 1;
	}

	// 删除客户类型
	public int deleteById(int cusTypeNo) {

		return cusTypeDao.deleteById(cusTypeNo);
	}

	// 查看所有的客户类型
	public List<CusType> findAll() {

		return cusTypeDao.findAll();
	}

	// 查看单个客户类型
	public CusType findById(int cusTypeNo) {

		return cusTypeDao.findById(cusTypeNo);
	}

	// 修改客户类型
	public int updateById(int cusTypeNo, String cusTypeDesc, int discount) {
		if (discount >= 1 && discount <= 10) {
			CusType cusType = cusTypeDao.findById(cusTypeNo);
			cusType.setCusTypeNo(cusTypeNo);
			cusType.setCusTypeDesc(cusTypeDesc);
			cusType.setDiscount(discount);

			return cusTypeDao.update(cusType);
		}
		return -1;
	}
}
