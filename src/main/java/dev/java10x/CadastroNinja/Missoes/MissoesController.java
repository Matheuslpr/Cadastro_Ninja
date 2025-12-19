package dev.java10x.CadastroNinja.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    final private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }


    @GetMapping ("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoesDTOS = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesDTOS);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> ListarMissoesId(@PathVariable Long id){
        MissoesDTO missoesId = missoesService.ListarMissoesId(id);
        if (missoesId != null){
            return ResponseEntity.ok(missoesId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: " + id + " não existe em nossos registros");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missaoDTO){
        MissoesDTO novaMissao = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @PutMapping("/alterar{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id,@RequestBody MissoesDTO missaoAtualizado){
        MissoesDTO missoesDTO = missoesService.alterarMissao(id,missaoAtualizado);
        if (missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: " + id + " não existe em nossos registros");
        }
    }

    @PutMapping("/deletar{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.ListarMissoesId(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com ID " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(("A Missão com ID " + id + " não encontrada"));
        }
    }

}