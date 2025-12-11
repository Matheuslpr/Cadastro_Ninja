package dev.java10x.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping ("/listar")
    public String listarMissao(){
        return "Missoes listadas com sucesso";
    }

    @PostMapping("/criar")
        public String criarMissao(){
        return "Missao Criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }


    @PutMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }
}