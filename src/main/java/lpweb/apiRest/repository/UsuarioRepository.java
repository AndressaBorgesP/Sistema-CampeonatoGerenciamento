package lpweb.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lpweb.apiRest.model.Jogador;

@Repository
public interface UsuarioRepository extends JpaRepository<Jogador, Long> {

}
