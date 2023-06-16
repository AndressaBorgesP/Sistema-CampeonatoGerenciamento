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

import lpweb.apiRest.model.Campeonato;
import lpweb.apiRest.repository.CampeonatoRepository;

@RestController
public class CampeonatoController {
	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	/*END-POINT para listar todos os usuários*/
    @GetMapping(value = "campeonatos")
    @ResponseBody
    public ResponseEntity<List<Campeonato>> listaCampeonato(){
    	
    	List<Campeonato> campeonatos = campeonatoRepository.findAll();
    	
    	return new ResponseEntity<List<Campeonato>>(campeonatos, HttpStatus.OK);
    }
    
    /*END-POINT para salvar um usuário*/
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Campeonato> salvar (@RequestBody Campeonato campeonato){
    	
    	Campeonato user = campeonatoRepository.save(campeonato);
    	
    	return new ResponseEntity<Campeonato>(user, HttpStatus.CREATED);
    	
    }
    
    /*END-POINT para deletar*/
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	
    	campeonatoRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Campeonato deletado com sucesso", HttpStatus.OK);
    	
    }
    
    /*END-POINT para busca por id*/
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Campeonato> buscaruserid(@RequestParam(name = "iduser") Long iduser){
    	
    	Campeonato campeonato = campeonatoRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Campeonato>(campeonato, HttpStatus.OK);
    	
    }
    
    /*END-POINT para atualizar usuário*/
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Campeonato campeonato){
    	
        if (campeonato.getId() == null) {
        	return new ResponseEntity<String>("Id não foi informado", HttpStatus.OK);
        }
    	
        Campeonato user = campeonatoRepository.saveAndFlush(campeonato);
    	
    	return new ResponseEntity<Campeonato>(user, HttpStatus.OK);
    	
    }

}
