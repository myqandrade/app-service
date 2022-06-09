package com.santana.java.back.end.service;

import com.santana.java.back.end.model.User;
import com.santana.java.back.end.model.UserDTO;
import com.santana.java.back.end.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll(){
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long userId){
        Optional<User> usuario = userRepository.findById(userId);
        if(usuario.isPresent()) {
            return UserDTO.convert(usuario.get());
        }
        return null;
    }
}
