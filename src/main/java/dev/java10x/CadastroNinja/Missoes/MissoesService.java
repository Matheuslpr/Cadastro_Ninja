package dev.java10x.CadastroNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService{

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    public MissoesModel ListarMissoesId(Long id){
        Optional<MissoesModel> missoesPorId= missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }
    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtualizado){
        if(missoesRepository.existsById(id)){
            missaoAtualizado.setId(id);
            return missoesRepository.save(missaoAtualizado);
        }
        return null;
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

}
