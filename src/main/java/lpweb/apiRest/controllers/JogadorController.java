package lpweb.apiRest.controllers;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lpweb.apiRest.model.Jogador;
import lpweb.apiRest.dto.JogadorDTO;
import lpweb.apiRest.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class JogadorController {
	@Autowired
	private UsuarioRepository usuarioRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	
	/*END-POINT para listar todos os usuários*/
    @GetMapping(value = "listatodos")
    @ResponseBody
    public ResponseEntity<List<Jogador>> listaJogador(){
    	
    	List<Jogador> jogadores = usuarioRepository.findAll();
    	
    	return new ResponseEntity<List<Jogador>>(jogadores, HttpStatus.OK);
    }
    
    /*END-POINT para salvar um usuário*/
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Jogador> salvar (@RequestBody Jogador jogador){
    	
    	Jogador user = usuarioRepository.save(jogador);
    	
    	return new ResponseEntity<Jogador>(user, HttpStatus.CREATED);
    	
    }
    
    /*END-POINT para deletar*/
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	
    	usuarioRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Usuário(Jogador) deletado com sucesso", HttpStatus.OK);
    	
    }
    
    /*END-POINT para busca por id*/
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Jogador> buscaruserid(@RequestParam(name = "iduser") Long iduser){
    	
    	Jogador jogador = usuarioRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);
    	
    }
    
    /*END-POINT para atualizar usuário*/
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Jogador jogador){
    	
        if (jogador.getId() == null) {
        	return new ResponseEntity<String>("Id não foi informado", HttpStatus.OK);
        }
    	
    	Jogador user = usuarioRepository.saveAndFlush(jogador);
    	
    	return new ResponseEntity<Jogador>(user, HttpStatus.OK);
    	
    }
    
  /*  @GetMapping(value = "search")
    public Page<JogadorDTO> searchJogadores(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        return jogadorService.searchJogadores(page, size);
    }*/
    

    
    
    
    
}