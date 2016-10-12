package hibernate_demo.dao;

import hibernate_demo.vo.Address;

public class AddressDao extends AbstractDao<Address> {

	public AddressDao() {
		super(Address.class);
	}

}
