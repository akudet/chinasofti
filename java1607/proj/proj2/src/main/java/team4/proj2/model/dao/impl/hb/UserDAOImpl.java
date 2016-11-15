package team4.proj2.model.dao.impl.hb;

import org.springframework.stereotype.Repository;

import team4.proj2.model.dao.UserDAO;
import team4.proj2.model.dao.impl.hb.abst.SpringAbstractDAO;
import team4.proj2.model.vo.User;

@Repository
public class UserDAOImpl extends SpringAbstractDAO<User> implements UserDAO {
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findOneByName(String name) {
		return findOne("FROM User WHERE name=?", name);
	}
}
