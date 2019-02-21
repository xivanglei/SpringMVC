package dao;

import model.User;

public interface UserDao {
	User findUserById(int id) throws Exception;
}
