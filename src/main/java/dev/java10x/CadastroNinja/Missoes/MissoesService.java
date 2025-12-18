package dev.java10x.CadastroNinja.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService{

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
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
