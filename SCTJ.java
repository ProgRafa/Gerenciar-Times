/*
	Autor: Rafael Pereira Oliveira
	Data de Desenvolvimento: 04/01/2019
	email para contato: functionoliveira@gmail.com
*/

//Sistema de Controle de Times e Jogadores	
public class SCTJ implements MeuTimeInterface{
	public List<Time> timesAutorizados;
	public List<Jogador> jogadoresAutorizados;
	
	SCTJ(){}
	
	public static Time procurarTime(Long idTime){
		Time time;
		
		time = timesAutorizados.search(idTime);
		
		return time;
	}
	
	public static Jogador procurarJogador(Long idJogador){
		Jogador jogador;
		
		jogador = jogadoresAutorizados.search(idTime);
		
		return jogador;
	}
	
	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){
			try{
				Time incluirTime;
			
				incluirTime = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			
				timesAutorizados.add(incluirTime);
			}catch(br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException identificadorExistente){
				
			}
			
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario){
		try{
			Jogador incluirJogador;
		
			Time time = SCTJ.procurarTime(idTime);
		
			incluirJogador = new Jogador(id, nome, dataNascimento, nivelHabilidade, salario);
			incluirJogador.timeAtual = time;
		
			time.incluirJogador(id, incluirJogador);
		}catch(br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException identificadorExistente){
			
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
		
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador){
		try{
			Jogador novoCapitao = SCTJ.procurarJogador(idJogador);
	
			novoCapitao.timeAtual.setCapitao(novoCapitao);
		}catch(br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException JogadorNaoEncontrado){
			
		}
		
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime){
		try{
			Time time = SCTJ.procurarTime(idTime);
		
			return time.getCapitaoDoTime().getId();
		}catch(br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException TimeSemCapitao){
			
		}
		
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador){
		try{
			return SCTJ.procurarJogador(idJogador).getNomeDoJogador();	
		}catch(br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException JogadorNaoEncontrado){
			
		}
		
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime){
		try{
			return SCTJ.procurarTime(idTime).getNomeDoTime();
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
	}
	
	@Desafio("buscarJogadoresDoTime")
	public List<Long> getJogadoresDoTime(Long idTime){	
		try{
			return SCTJ.procurarTime(idTime).getJogadores();
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
	}
	
	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime){
		try{
			return SCTJ.procurarTime(idTime).getEstrelaDoTime().getId();
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
	}
	
	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime){
		try{
			return SCTJ.procurarTime(idTime).getVovoDoTime().getId();
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
	}
	
	@Desafio("buscarMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime){
		try{
			return SCTJ.procurarTime(idTime).getJogadorMelhorRemunerado().getId();
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
		
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador){
		try{
			return SCTJ.procurarJogador(idJogador).getSalario();
		}catch(br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException JogadorNaoEncontrado){
			
		}
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top){
		return new List<Long>();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes(){
			return new List<Long>();
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long idTimeDeCase, Long idTimeDeFora){
		try{
			Time timeDeCasa = SCTJ.procurarTime(idTimeDeCase);
			Time timeDeFora = SCTJ.procurarTime(idTimeDeFora);
			
			String tcUniPrin = timeDeCasa.corUniformePrincipal.toUpperCase();
			String tfUniPrin = timeDeFora.corUniformePrincipal.toUpperCase();
			
			if(tcUniPrin.equals(tfUniPrin)){
				return timeDeFora.corUniformeSecundario;
			}else{
				return timeDeFora.corUniformePrincipal;
			}
		}catch(br.com.codenation.desafio.exceptions.TimeNaoEncontradoException TimeNaoEncontrado){
			
		}
	}
}