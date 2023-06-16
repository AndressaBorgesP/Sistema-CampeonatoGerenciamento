package lpweb.apiRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lpweb.apiRest.model.Partida;

@Repository
@Transactional
public interface PartidaRepository  extends JpaRepository<Partida, Long> {
	
    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId AND p.data < CURRENT_TIMESTAMP")
    List<Partida> findPartidasOcorridasByCampeonatoId(@Param("campeonatoId") Long campeonatoId);

    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId AND p.data >= CURRENT_TIMESTAMP")
    List<Partida> findPartidasNaoOcorridasByCampeonatoId(@Param("campeonatoId") Long campeonatoId);

}
