package dev.java10x.CadastroNinja.Missoes;

import dev.java10x.CadastroNinja.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissoesService{

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel ListarMissoesId(Long id){
        Optional<MissoesModel> missoesPorId= missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }
}
