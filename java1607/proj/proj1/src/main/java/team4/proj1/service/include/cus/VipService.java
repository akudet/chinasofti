package team4.proj1.service.include.cus;

import java.util.*;

import team4.proj1.model.dao.impl.jdbc.CusInfoDAOImpl;
import team4.proj1.model.dao.impl.jdbc.CusTypeDAOImpl;
import team4.proj1.model.dao.impl.jdbc.VipDAOImpl;
import team4.proj1.model.vo.cus.CusInfo;
import team4.proj1.model.vo.cus.CusType;
import team4.proj1.model.vo.cus.Vip;

/**
 * 
 * @author 马厦伟
 * 
 */
public interface VipService {

	// 参考 2.7 会员管理

	public int add(int vipNumber, String name, String sex, String certNumber,
			String phone, String address, String comment);

	public int deleteByVipNo(int vipNumber);

	public List<Vip> findAll();

	// 按会员名字查询
	public Vip findOneByName(String name);

	// 通过会员编号查询
	public Vip findOneByVipNo(int vipNo);

	// 通过会员姓名查询
	public Vip findOneByVipNo(String vipNumber);

	// 根据提供的信息对信息进行修改
	public int update(int vipNumber, String name, String sex,
			String certNumber, String phone, String address, String comment);
}
