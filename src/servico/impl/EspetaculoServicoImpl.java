package servico.impl;

import java.util.List;

import dao.EspetaculoDao;
import dao.DaoFactory;
import dao.jpa.EM;
import dominio.Espetaculo;
import servico.EspetaculoServico;

public class EspetaculoServicoImpl implements EspetaculoServico {

private EspetaculoDao dao;
	
	public EspetaculoServicoImpl(){
		dao = DaoFactory.criarEspetaculoDao();
	}
	
	@Override
	public void inserirAtualizar(Espetaculo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public void excluir(Espetaculo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public Espetaculo buscar(int cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<Espetaculo> buscarTodos() {
		return dao.buscarTodos();
	}

}
