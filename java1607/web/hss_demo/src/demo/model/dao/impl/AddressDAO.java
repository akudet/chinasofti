package demo.model.dao.impl;

import demo.model.dao.abst.AbstractDAO;
import demo.model.vo.Address;

public class AddressDAO extends AbstractDAO<Address> {

	public AddressDAO() {
		super(Address.class);
	}

}
