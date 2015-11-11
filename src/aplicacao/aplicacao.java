package aplicacao;

import java.math.BigDecimal;

import dominio.Banda;
import servico.BandaServico;
import servico.ServicoFactory;

public class aplicacao {

	public static void main(String[] args) {

		BandaServico bandaServico = ServicoFactory.criarBandaServico();

		BigDecimal p1 = new BigDecimal("2000.00");
		BigDecimal p2 = new BigDecimal("4000.00");
		BigDecimal p3 = new BigDecimal("6000.00");
		BigDecimal p4 = new BigDecimal("8000.00");
		BigDecimal p5 = new BigDecimal("10000.00");

		Banda b1 = new Banda(null, "Capital Inicial", p1);
		Banda b2 = new Banda(null, "Jota Quest", p2);
		Banda b3 = new Banda(null, "Oficina G3", p3);
		Banda b4 = new Banda(null, "U2", p4);
		Banda b5 = new Banda(null, "Calypso", p5);

		bandaServico.inserirAtualizar(b1);
		bandaServico.inserirAtualizar(b2);
		bandaServico.inserirAtualizar(b3);
		bandaServico.inserirAtualizar(b4);
		bandaServico.inserirAtualizar(b5);
		
		System.out.println("Pronto!");

	}

}
