package com.santana.java.back.end.application.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="user", schema="public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

//converte userDTO para user
    public static User convert(UserDTO userDTO){
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setCpf(userDTO.getCpf());
        user.setEndereco(userDTO.getEndereco());
        user.setEmail(userDTO.getEmail());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(userDTO.getDataCadastro());

        return user;
    }
}
