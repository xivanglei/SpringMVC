package mapper;

import model.User;

public interface UserQueryMapper {
	User findUserById(int id) throws Exception;
}
