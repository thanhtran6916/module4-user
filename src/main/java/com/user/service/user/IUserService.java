package com.user.service.user;

import com.user.model.User;
import com.user.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Optional<User> findByEmail(String email);
}
