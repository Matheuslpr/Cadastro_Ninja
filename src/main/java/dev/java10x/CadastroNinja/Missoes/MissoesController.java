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
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missaoDTO){
        return missoesService.criarMissao(missaoDTO);
    }

    @PutMapping("/alterar{id}")
    public MissoesModel alterarMissao(@PathVariable Long id,@RequestBody MissoesModel missaoAtualizado){
        return missoesService.alterarMissao(id,missaoAtualizado);
    }

    @PutMapping("/deletar{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}