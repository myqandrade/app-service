package com.santana.java.back.end.application.controller;


import com.santana.java.back.end.application.model.UserDTO;
import com.santana.java.back.end.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> usuarios = userService.getAll();
        return ResponseEntity.ok(usuarios);
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
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome){
        return userService.queryByNomeLike(nome);
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
