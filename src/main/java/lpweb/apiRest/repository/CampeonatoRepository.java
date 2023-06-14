package lpweb.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lpweb.apiRest.model.Campeonato;

@Repository
@Transactional
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long>{

}
