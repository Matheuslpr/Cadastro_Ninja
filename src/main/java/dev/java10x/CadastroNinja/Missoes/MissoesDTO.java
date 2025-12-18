package dev.java10x.CadastroNinja.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data
public class MissoesDTO {

    private  Long id;
    private String nome;
    private String descricao;
    private String dificuldade;
    @JsonIgnore
    private List<NinjaModel> ninjas;
}
