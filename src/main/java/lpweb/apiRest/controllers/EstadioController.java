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

import lpweb.apiRest.model.Estadio;
import lpweb.apiRest.repository.EstadioRepository;

@RestController
public class EstadioController {
	
	@Autowired
	private EstadioRepository estadioRepository; 
	
	@GetMapping(value = "estadios")
    @ResponseBody
    public ResponseEntity<List<Estadio>> listaEstadio(){
    	
    	List<Estadio> estadios = estadioRepository.findAll();
    	
    	return new ResponseEntity<List<Estadio>>(estadios, HttpStatus.OK);
    }
    
    /*END-POINT para salvar um usuário*/
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Estadio> salvar (@RequestBody Estadio estadio){
    	
    	Estadio user = estadioRepository.save(estadio);
    	
    	return new ResponseEntity<Estadio>(user, HttpStatus.CREATED);
    	
    }
    
    /*END-POINT para deletar*/
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	
    	estadioRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Estadio deletado com sucesso", HttpStatus.OK);
    	
    }
    
    /*END-POINT para busca por id*/
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Estadio> buscaruserid(@RequestParam(name = "iduser") Long iduser){
    	
    	Estadio estadio = estadioRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Estadio>(estadio, HttpStatus.OK);
    	
    }
    
    /*END-POINT para atualizar usuário*/
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Estadio estadio){
    	
        if (estadio.getId() == null) {
        	return new ResponseEntity<String>("Id não foi informado", HttpStatus.OK);
        }
    	
        Estadio user = estadioRepository.saveAndFlush(estadio);
    	
    	return new ResponseEntity<Estadio>(user, HttpStatus.OK);
    	
    }

}