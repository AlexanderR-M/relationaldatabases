package relationaldatabases;

import relationaldatabases.dao.UserDao;
import relationaldatabases.dao.UserDaoImpl;
import relationaldatabases.model.User;

public class UserDaoTest {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		userDao.insert(new User(0, "Alex", "admin", 0, "19", 2323232, true, "macho", "un buen tio"));
		
		
		
		
	}

}
