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

import lpweb.apiRest.repository.ResultadoRepository;
import lpweb.apiRest.model.Resultados;

@RestController
public class ResultadoController {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	/*END-POINT para listar todos os usuários*/
    @GetMapping(value = "resultados")
    @ResponseBody
    public ResponseEntity<List<Resultados>> listaJogador(){
    	
    	List<Resultados> resultados = resultadoRepository.findAll();
    	
    	return new ResponseEntity<List<Resultados>>(resultados, HttpStatus.OK);
    }
    
    /*END-POINT para salvar um usuário*/
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Resultados> salvar (@RequestBody Resultados resultado){
    	
    	Resultados user = resultadoRepository.save(resultado);
    	
    	return new ResponseEntity<Resultados>(user, HttpStatus.CREATED);
    	
    }
    
    /*END-POINT para deletar*/
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	
    	resultadoRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Resultado deletado com sucesso", HttpStatus.OK);
    	
    }
    
    /*END-POINT para busca por id*/
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Resultados> buscaruserid(@RequestParam(name = "iduser") Long iduser){
    	
    	Resultados resultado = resultadoRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Resultados>(resultado, HttpStatus.OK);
    	
    }
    
    /*END-POINT para atualizar usuário*/
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Resultados resultado){
    	
        if (resultado.getId() == null) {
        	return new ResponseEntity<String>("Id não foi informado", HttpStatus.OK);
        }
    	
        Resultados user = resultadoRepository.saveAndFlush(resultado);
    	
    	return new ResponseEntity<Resultados>(user, HttpStatus.OK);
    	
    }

}
