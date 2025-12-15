package dev.java10x.CadastroNinja.Ninjas;

import dev.java10x.CadastroNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//TABELA
@Entity
@Table(name = "tb_cadastro")

//CONSTRUTORES
@NoArgsConstructor
@AllArgsConstructor

//GETTERS E SETTERS
@Data


public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
