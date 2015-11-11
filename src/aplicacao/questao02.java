package aplicacao;

import java.util.List;
import java.util.Scanner;

import dominio.Banda;
import dominio.Espetaculo;
import dominio.Participacao;
import servico.BandaServico;
import servico.EspetaculoServico;
import servico.ParticipacaoServico;
import servico.ServicoFactory;

public class questao02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int op = 0;

		do {
			System.out.println("\n01 - Cadastrar um novo espet�culo e as participa��es dele");
			System.out.println("\n02 - Mostrar os dados de um espet�culo (nome, pre�o total e participa��es)");
			System.out.println("\n 3 - Sair");
			System.out.println("Digite uma op��o: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
			case 1:
				System.out.println("Digite o nome do espetaculo a ser cadastrado: ");
				String nome = sc.nextLine();
				Espetaculo esp = new Espetaculo(null, nome);
				EspetaculoServico es = ServicoFactory.criarEspetucaloServico();
				es.inserirAtualizar(esp);

				System.out.println("\nQuantas participacoes este espetaculo vai ter? ");
				int N = Integer.parseInt(sc.nextLine());

				BandaServico bs = ServicoFactory.criarBandaServico();
				List<Banda> listaBandas = bs.buscarTodos();
				System.out.println("\nBandas existentes: ");
				for (Banda x : listaBandas) {
					System.out.println(x);
				}

				ParticipacaoServico ps = ServicoFactory.criarParticipacaoServico();

				for (int i = 1; i <= N; i++) {
					System.out.println("Digite o c�digo da " + i + "a. banda do espetaculo: ");
					int cod = Integer.parseInt(sc.nextLine());
					Banda banda = bs.buscar(cod);
					Participacao part = new Participacao(null, i, banda, esp);
					ps.inserirAtualizar(part);
				}

				break;
			case 2:

				break;

			case 3:
				System.out.println("Fim do programada!");

			default:
				System.out.println("Op��o inv�lida!");
			}

		} while (op != 3);

	}
}
