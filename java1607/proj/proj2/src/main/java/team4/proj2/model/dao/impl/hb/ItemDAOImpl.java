package team4.proj2.model.dao.impl.hb;

import org.springframework.stereotype.Repository;

import team4.proj2.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj2.model.vo.Item;

@Repository
public class ItemDAOImpl extends SpringAbstractDAO<Item> {
	
	public ItemDAOImpl() {
		super(Item.class);
	}

}
