package service;

import java.util.List;

import model.Users;

public interface UsersService {

	public void saveSe(Users users);

	public void update(Users users);

	public void delete(int id);
	
	public void resetAutoIncrement();

	public List<Users> readUsers();

	public Users getUsers(int id);
	
	public boolean exsist(String username);

}
