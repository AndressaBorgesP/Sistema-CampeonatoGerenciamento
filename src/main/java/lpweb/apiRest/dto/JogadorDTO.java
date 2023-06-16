package lpweb.apiRest.dto;

import lpweb.apiRest.model.Jogador;

import lpweb.apiRest.model.Time;

public class JogadorDTO {
	
	private Long id;

    private String nome;
    private String dataNascimento;
    private double altura;
    private String nomeTime;
    
    public JogadorDTO(Long id, String nome, String dataNascimento, double altura, Time nomeTime) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.nomeTime = nomeTime.getNome();
    }

    public static JogadorDTO fromJogador(Jogador jogador){
        return new JogadorDTO(jogador.getId(),
                jogador.getNome(),
                jogador.getDataNascimento(),
                jogador.getAltura(),
                jogador.getTime());
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
    
    
}
	

