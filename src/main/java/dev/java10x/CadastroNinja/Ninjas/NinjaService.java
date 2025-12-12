package dev.java10x.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    //da acesso ao repositorio
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    //Listar ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();// findall equivale a insert
    }






}
