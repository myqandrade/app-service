package com.santana.java.back.end.controller;


import com.santana.java.back.end.model.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMensagem(){
        return "Spring boot is working!";
    }

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList(){

        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua A");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3435");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Mike");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua Dois");
        userDTO2.setEmail("mike.andrade@email.com");
        userDTO2.setTelefone("654-9878");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Matheus");
        userDTO3.setCpf("765");
        userDTO3.setEndereco("Rua B");
        userDTO3.setEmail("math.toledo@email.com");
        userDTO3.setTelefone("6548-0989");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return usuarios;
    }

    /**Vou passar um CPF para o método e ele vai comparar com um CPF que esteja entre os usuários da lista.
    se encontrar, o usuário será retornado. Se não, retornará null. */
    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf){
        for(UserDTO userFilter : usuarios){
            if (userFilter.getCpf().equals(cpf)){
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO){
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

/* vai percorrer a lista usuarios (do tipo userDTO) e se encontrar um cpf igual ao que foi passado, o usuário será deletado
*/
    @DeleteMapping("/users/{cpf}")
    public boolean remover(@PathVariable String cpf){
        for(UserDTO userFilter : usuarios){
            if(userFilter.getCpf().equals(cpf))
                usuarios.remove(userFilter);
        }
        return false;
    }
}
