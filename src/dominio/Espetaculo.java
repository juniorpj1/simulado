package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_espetaculo")
public class Espetaculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codEspetaculo;
	private String nome; 
	
	@OneToMany(mappedBy="espetaculo")
	private List<Participacao> participacoes;
	
	public Espetaculo(){
		this.participacoes = new ArrayList<Participacao>();
	}

	public Espetaculo(Integer codEspetaculo, String nome) {
		super();
		this.codEspetaculo = codEspetaculo;
		this.nome = nome;
		this.participacoes = new ArrayList<Participacao>();
	}

	public Integer getCodEspetaculo() {
		return codEspetaculo;
	}

	public void setCodEspetaculo(Integer codEspetaculo) {
		this.codEspetaculo = codEspetaculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao x){
		this.participacoes.add(x);
	}
	
	public void addPartipacao(Participacao x){
		this.participacoes.remove(x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEspetaculo == null) ? 0 : codEspetaculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espetaculo other = (Espetaculo) obj;
		if (codEspetaculo == null) {
			if (other.codEspetaculo != null)
				return false;
		} else if (!codEspetaculo.equals(other.codEspetaculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Espetaculo [codEspetaculo=" + codEspetaculo + ", nome=" + nome + "]";
	}
	
	public BigDecimal precoTotal(){
		BigDecimal a = new BigDecimal("0.00");
		
		for(int i = 0; i < participacoes.size(); i++){
			a = a.add(this.participacoes.get(i).getBanda().getPreco());
		}
		
		return a;
	}

	
	
	
	
}
