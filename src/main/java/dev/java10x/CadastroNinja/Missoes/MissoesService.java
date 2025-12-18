package dev.java10x.CadastroNinja.Missoes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService{

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public MissoesDTO ListarMissoesId(Long id){
        Optional<MissoesModel> missoesPorId= missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }
    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizado = missoesMapper.map(missoesDTO);
            missaoAtualizado.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizado);
            return  missoesMapper.map(missaoSalva);
        }
        return null;
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

}
