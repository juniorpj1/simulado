package servico;

import java.util.List;

import dominio.Participacao;

public interface ParticipacaoServico {
	public void inserirAtualizar(Participacao x);
	public void excluir(Participacao x);
	public Participacao buscar(int cod);
	public List<Participacao> buscarTodos();
}
