package dao;

import java.util.List;

import dominio.Banda;

public interface BandaDao {
	public void inserirAtualizar(Banda x);
	public void excluir(Banda x);
	public Banda buscar(int cod);
	public List<Banda> buscarTodos();
}
