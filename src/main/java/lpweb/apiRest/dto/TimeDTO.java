package lpweb.apiRest.dto;
import lpweb.apiRest.model.Time;

public class TimeDTO {
	 private Long id;
	    private String nome;
	    private int vitorias;
	    private int saldoGols;
	    	    
	    public TimeDTO(Long id, String nome, int vitorias, int saldoGols) {
	        this.id = id;
	        this.nome = nome;
	        this.vitorias = vitorias;
	        this.saldoGols = saldoGols;
	    }

	    public static TimeDTO fromTime(Time time) {
	        return new TimeDTO(time.getId(), time.getNome(), time.getVitorias(), time.getSaldoGols());
	    }
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getVitorias() {
			return vitorias;
		}
		public void setVitorias(int vitorias) {
			this.vitorias = vitorias;
		}
		public int getSaldoGols() {
			return saldoGols;
		}
		public void setSaldoGols(int saldoGols) {
			this.saldoGols = saldoGols;
		}
	    
	    
	    

}
