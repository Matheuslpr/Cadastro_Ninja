package dev.java10x.CadastroNinja.Missoes;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping ("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel ListarMissoesId(@PathVariable Long id){
        return missoesService.ListarMissoesId(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
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