package com.gestor.condominio.services;

import com.gestor.condominio.models.User;
import com.gestor.condominio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listarTodosUsuarios() {
        return userRepository.findAll();
    }


    public void salvarUsuario(User user) {
        userRepository.save(user);
    }


}