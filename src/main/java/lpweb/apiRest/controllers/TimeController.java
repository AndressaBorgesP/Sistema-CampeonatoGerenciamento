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

import lpweb.apiRest.model.Time;
import lpweb.apiRest.repository.TimeRepository;

@RestController
public class TimeController {
	
	@Autowired
	private TimeRepository timeRepository;
	
	/*END-POINT para listar todos os usuários*/
    @GetMapping(value = "times")
    @ResponseBody
    public ResponseEntity<List<Time>> listaTime(){
    	
    	List<Time> times = timeRepository.findAll();
    	
    	return new ResponseEntity<List<Time>>(times, HttpStatus.OK);
    }
    
    /*END-POINT para salvar um usuário*/
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Time> salvar (@RequestBody Time time){
    	
    	Time user = timeRepository.save(time);
    	
    	return new ResponseEntity<Time>(user, HttpStatus.CREATED);
    	
    }
    
    /*END-POINT para deletar*/
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	
    	timeRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Time deletado com sucesso", HttpStatus.OK);
    	
    }
    
    /*END-POINT para busca por id*/
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Time> buscaruserid(@RequestParam(name = "iduser") Long iduser){
    	
    	Time time = timeRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Time>(time, HttpStatus.OK);
    	
    }
    
    /*END-POINT para atualizar usuário*/
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Time time){
    	
        if (time.getId() == null) {
        	return new ResponseEntity<String>("Id não foi informado", HttpStatus.OK);
        }
    	
        Time user = timeRepository.saveAndFlush(time);
    	
    	return new ResponseEntity<Time>(user, HttpStatus.OK);
    	
    }
    
/*     @GetMapping(value = "/campeonato/{id}")
    public ResponseEntity<List<TimeDTO>> getTimesByCampeonatoId(@PathVariable Long id) {
        List<TimeDTO> times = timeService.getTimesByCampeonatoId(id);
        return new ResponseEntity<List<Time>>(times, HttpStatus.OK);
    }

    @GetMapping(value = "/tabela-campeonato/{id}")
    public List<TimeDTO> getTabelaCampeonato(@PathVariable Long id) {
        return timeService.getTabelaCampeonatoById(id);
    }

 * */   

}
