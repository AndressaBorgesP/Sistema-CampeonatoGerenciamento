package lpweb.apiRest.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Partida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	
	@ManyToOne
	@JoinColumn(name ="time_mandante_id")
	private Time timeMandante;
	
	@ManyToOne
	@JoinColumn(name ="time_visitante_id")
	private Time timeVisitante;
	
	 private Date data;
	
	
	@ManyToOne
	@JoinColumn(name ="campeonato_id")
	private Campeonato campeonato;
	
	@ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @OneToOne(mappedBy = "partida", cascade = CascadeType.ALL)
    private Resultados resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getTimeMandante() {
		return timeMandante;
	}

	public void setTimeMandante(Time timeMandante) {
		this.timeMandante = timeMandante;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Resultados getResultado() {
		return resultado;
	}

	public void setResultado(Resultados resultado) {
		this.resultado = resultado;
	}






	
	

}
