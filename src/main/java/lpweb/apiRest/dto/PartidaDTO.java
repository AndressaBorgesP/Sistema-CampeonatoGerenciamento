package lpweb.apiRest.dto;

import lpweb.apiRest.model.Partida;
import lpweb.apiRest.model.Resultados;

public class PartidaDTO {
	
	    private Long id;
	    private String timeMandante;
	    private String timeVisitante;
	    private Resultados resultado;
	    
	    public PartidaDTO(Long id, String timeMandante, String timeVisitante, Resultados resultado) {
	        this.id = id;
	        this.timeMandante = timeMandante;
	        this.timeVisitante = timeVisitante;
	        this.resultado = resultado;
	    }

	    public static PartidaDTO fromPartida(Partida partidas){
	        return new PartidaDTO(partidas.getId(),
	                partidas.getTimeMandante().getNome(),
	                partidas.getTimeVisitante().getNome(),
	                partidas.getResultado());
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTimeMandante() {
			return timeMandante;
		}

		public void setTimeMandante(String timeMandante) {
			this.timeMandante = timeMandante;
		}

		public String getTimeVisitante() {
			return timeVisitante;
		}

		public void setTimeVisitante(String timeVisitante) {
			this.timeVisitante = timeVisitante;
		}

		public Resultados getResultado() {
			return resultado;
		}

		public void setResultado(Resultados resultado) {
			this.resultado = resultado;
		}
	    


	    


}
