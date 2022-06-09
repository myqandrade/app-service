package com.santana.java.back.end.controller;


import com.santana.java.back.end.model.UserDTO;
import com.santana.java.back.end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/id/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/user/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf){
        return userService.findByCpf(cpf);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String name){
        return userService.queryByNameLike(name);
    }

    @PostMapping("/newUser")
    UserDTO newUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @DeleteMapping("/deleteUser/id/{id}")
    UserDTO delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
