import Java.Time.LocalDate;

public class Jogador{
	private Long idJogador;
	private Integer nvHabilidadeJogador;
	private String nomeJogador;
	private LocalDate dtNascimentoJogador;
	private BigDecimal salarioJogador;
	public Time timeAtual;
	
	Jogador(Long id, Integer nvHabilidade, String nome, LocalDate dtNascimento, BigDecimal salario){
		this.idJogador = id;
		this.nvHabilidadeJogador = nvHabilidade;
		this.nomeJogador = nome;
		this.dtNascimentoJogador = dtNascimento;
		this.salarioJogador = salario;
		this.timeAtual = null;
	} 
	
	public Long getId(){
		return this.idJogador;
	}
	
	public Integer getHabilidade(){
		return this.nvHbailidadeJogador;
	}
	
	public String getNomeDoJogador(){
		return this.nomeJogador;
	}
	
	public LocalDate getDataNascimento(){
		return this.dtNascimentoJogador;
	}
	
	public BigDecimal getSalario(){
		return this.salarioJogador;
	}
}