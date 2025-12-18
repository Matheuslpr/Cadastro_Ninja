package dev.java10x.CadastroNinja.Ninjas;

import dev.java10x.CadastroNinja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data

public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private String rank;
    private int idade;
    private MissoesModel missoes;
}
