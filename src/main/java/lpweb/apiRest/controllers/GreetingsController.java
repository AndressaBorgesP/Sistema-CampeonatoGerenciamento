package lpweb.apiRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lpweb.apiRest.model.Jogador;
import lpweb.apiRest.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */

    
    
    @GetMapping(value = "listatodos")
    @ResponseBody
    public ResponseEntity<List<Jogador>> listaJogador(){
    	
    	List<Jogador> jogadores = usuarioRepository.findAll();
    	
    	return new ResponseEntity<List<Jogador>>(jogadores, HttpStatus.OK);
    }
}
