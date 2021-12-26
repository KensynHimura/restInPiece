package com.restinpeace.service;

import com.restinpeace.entities.User;
import com.restinpeace.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        user.getAuthorities().size();
        return user;
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    public User getUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void deleteUser(Long id) {
        userRepository.delete(getUserByID(id));
    }
}
