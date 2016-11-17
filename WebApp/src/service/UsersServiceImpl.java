package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.Users;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void saveSe(Users users) {
		userDao.save(users);
	}

	@Transactional
	public void update(Users users) {
		userDao.update(users);
	}

	@Transactional
	public void delete(int id) {
		userDao.delete(id);
	}

	@Transactional
	public void resetAutoIncrement() {

		userDao.resetAutoIncrement();

	}

	@Transactional
	public List<Users> readUsers() {

		return userDao.readUsers();

	}

	@Transactional
	public Users getUsers(int id) {

		return userDao.getUsers(id);

	}

	@Transactional
	public boolean exsist(String username) {

		return userDao.exsist(username);

	}

}
