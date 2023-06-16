package lpweb.apiRest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Resultados implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int golsTimeMandante;
	private int golsTimeVisitante;
	
	@OneToOne
	@JoinColumn(name = "partida_id")
	private Partida partida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGolsTimeMandante() {
		return golsTimeMandante;
	}

	public void setGolsTimeMandante(int golsTimeMandante) {
		this.golsTimeMandante = golsTimeMandante;
	}

	public int getGolsTimeVisitante() {
		return golsTimeVisitante;
	}

	public void setGolsTimeVisitante(int golsTimeVisitante) {
		this.golsTimeVisitante = golsTimeVisitante;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	

}
