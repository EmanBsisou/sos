package sos.services;

import sos.domain.User;

public interface UserService {

	public User createUpdateUser(User user);
	public User getUserByUserId(String userId);
}
