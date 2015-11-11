package servico;

import java.util.List;

import dominio.Banda;

public interface BandaServico {
	public void inserirAtualizar(Banda x);
	public void excluir(Banda x);
	public Banda buscar(int cod);
	public List<Banda> buscarTodos();
}
