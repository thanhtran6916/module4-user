package com.user.service.user;

import com.user.model.User;
import com.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        userRepository.deleteById(id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
