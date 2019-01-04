import java.time.LocalDate;

public class Time{
	private Long idTime;
	private String nomeTime;
	private LocalDate dtFundacaoTime;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	private Jogador capitaoTime;
	private Jogador estrelaDoTime;
	private Jogador vovoDoTime;
	private HashTable<Long, Jogador> jogadoresDoTime;
	
	Time(Long id, String nome, LocalDate dtFundacao, String cUnifPrincipal, String cUnifSecund){
		this.idTime = id;
		this.nomeTime = nome;
		this.dtFundacaoTime = dtFundacao;
		this.corUniformePrincipal = cUnifPrincipal;
		this.corUniformeSecundario = cUnifSecund;
		this.jogadoresDoTime = new HashTable<Long, Jogador>();
		this.capitaoTime = null;
		this.estrelaDoTime = null;
		this.vovoDoTime = null;
	}
	
	/*Getters*/
	public Long getIdTime(){
		return this.idTime;
	}
	
	public String getNomeDoTime(){
		return this.nomeTime;
	}
	
	public LocalDate getDataDeFundacao(){
		return this.dtFundacaoTime;
	}
	
	public String getCorUniformPrincipal(){
		return this.corUniformePrincipal;
	}
	
	public String getCorUniformSecundario(){
		return this.corUniformeSecundario;
	}
	
	public Jogador getCapitaoDoTime(){
		try{
			return this.capitaoTime;
		}catch(){
			
		}
	}
	
	public List<Jogador> getJogadoresDoTime(){
		try{
			return this.jogadoresDoTime;
		}catch(){
			
		}	
	}
	
	public Jogador getJogadorMelhorRemunerado(){
		try{
			Jogador jogadorMaiorSalario;
			int qtdJogadoresDoTime = this.jogadoresDoTime.size();
			
			jogadorMaiorSalario = this.jogadoresDoTime[0];
			
			for(int i = 1; i < qtdJogadoresDoTime; i++){
				if(jogadorMaiorSalario.getSalario() < this.jogadoresDoTime[i].getSalario()){
					jogadorMaiorSalario = this.jogadoresDoTime[i];  	
				}	
			}
			
			return jogadorMaiorSalario;
		}catch(){
			
		}	
	}
	
	public Jogador getEstrelaDoTime(){
		try{
			return this.estrelaDoTime;	
		}catch(){
			
		}
	}
	
	public Jogador getVovoDoTime(){
		try{
			return this.vovoDoTime;
		}catch(){
			
		}
	}
	
	public List<Jogador> topJogadoresDoTime(Integer top){
		try{
			
		}catch(){
			
		}
	}

	
	/*Setters*/
	public String incluirJogador(Long id, Jogador jogador){
		try{
			Retorno<String> ret = new Retorno<String>();
			
			this.jogadoresDoTime.put(id, jogador);
			
			if(this.estrelaDoTime == null){
				this.estrelaDoTime = jogador;
			}else if(this.estrelaDoTime.getHabilidade() < jogador.getHabilidade()){
				this.estrelaDoTime = jogador;
			}
			
			if(this.vovoDoTime == null){
				this.vovoDoTime = jogador;
			}else if(this.vovoDoTime.getDataNascimento() < jogador.getDataNascimento()){
				this.vovoDoTime = jogador;
			}
			
			return "Jogador incluido com sucesso !";
		}catch(Exception ex){
			return "Falha ao incluir o jogador";
		}
	}
	
	public String setCapitao(Jogador capitao){
		try{
			this.capitaoTime = capitao;
			
			return capitaoTime.getNomeJogador().concat(" é o capitão do time.");
		}catch(){
			return "Falha ao incluir o capitão !";
		}
	}
}