package dev.java10x.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService  ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return  "Essa é a minha primeira mensage nessa rota";
    }
    //Adicionar (create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }
    //Mostrar por id
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasId(@PathVariable Long id){
        return ninjaService.listarNinjasId(id);
    }
    //Mostar Todos  (read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
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
