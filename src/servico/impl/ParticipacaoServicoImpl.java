package servico.impl;

import java.util.List;

import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.jpa.EM;
import dominio.Participacao;
import servico.ParticipacaoServico;

public class ParticipacaoServicoImpl implements ParticipacaoServico {

private ParticipacaoDao dao;
	
	public ParticipacaoServicoImpl(){
		dao = DaoFactory.criarParticipacaoDao();
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public void excluir(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	@Override
	public Participacao buscar(int cod) {
		return dao.buscar(cod);
	}

	@Override
	public List<Participacao> buscarTodos() {
		return dao.buscarTodos();
	}

}
