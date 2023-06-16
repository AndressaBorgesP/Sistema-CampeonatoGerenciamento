package lpweb.apiRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lpweb.apiRest.model.Partida;
import lpweb.apiRest.repository.PartidaRepository;

@RestController
public class PartidaController {
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	/*END-POINT para listar todos os usuários*/
    @GetMapping(value = "partidas")
    @ResponseBody
    public ResponseEntity<List<Partida>> listaPartida(){
    	
    	List<Partida> partidas = partidaRepository.findAll();
    	
    	return new ResponseEntity<List<Partida>>(partidas, HttpStatus.OK);
    }
    
    /*END-POINT para salvar um usuário*/
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Partida> salvar (@RequestBody Partida partida){
    	
    	Partida user = partidaRepository.save(partida);
    	
    	return new ResponseEntity<Partida>(user, HttpStatus.CREATED);
    	
    }
    
    /*END-POINT para deletar*/
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	
    	partidaRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Partida deletado com sucesso", HttpStatus.OK);
    	
    }
    
    /*END-POINT para busca por id*/
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Partida> buscaruserid(@RequestParam(name = "iduser") Long iduser){
    	
    	Partida partida = partidaRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Partida>(partida, HttpStatus.OK);
    	
    }
    
    /*END-POINT para atualizar usuário*/
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Partida partida){
    	
        if (partida.getId() == null) {
        	return new ResponseEntity<String>("Id não foi informado", HttpStatus.OK);
        }
    	
        Partida user = partidaRepository.saveAndFlush(partida);
    	
    	return new ResponseEntity<Partida>(user, HttpStatus.OK);
    	
    }
    
    /*
     *  @GetMapping(value = "/campeonatos/{campeonatoId}/partidas/ocorridas")
    public List<Partida> getPartidasOcorridas(@PathVariable Long campeonatoId) {
        return partidaService.getPartidasOcorridas(campeonatoId);
    }

    @GetMapping(value = "/campeonatos/{campeonatoId}/partidas/nao-ocorridas")
    public List<Partida> getPartidasNaoOcorridas(@PathVariable Long campeonatoId) {
        return partidaService.getPartidasNaoOcorridas(campeonatoId);
    }*/

}
