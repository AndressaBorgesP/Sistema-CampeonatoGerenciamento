package lpweb.apiRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lpweb.apiRest.model.Jogador;

@Repository
public interface UsuarioRepository extends JpaRepository<Jogador, Long> {
	
	@Query(value = "select u from Jogador u where trim(u.nome) like %?1%")
	List<Jogador> buscaPorNome(String nome);

}
