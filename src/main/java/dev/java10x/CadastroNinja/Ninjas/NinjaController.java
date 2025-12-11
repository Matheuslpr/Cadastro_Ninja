package dev.java10x.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return  "Essa é a minha primeira mensage nessa rota";
    }
    //adicionar ninja(create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado com sucesso";
    }
    //mostrar todos os ninjas
    @GetMapping("/listarID")
    public String listarNinja(){
        return "NinjaS listados com sucesso";
    }
    //mostar ninjas por id (read)
    @GetMapping("/todosID")
    public String mostrarNinjaPorId(){
        return "Mostrar Ninja Por ID";
    }
    //alterar dados(update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja Por id";
    }
    //deletar ninja (delete)
    @DeleteMapping("/deletar por id")
    public String deletarPorId(){
        return "Ninja deletado por id";
    }
}
