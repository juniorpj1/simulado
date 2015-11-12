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

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int op = 0;
		EspetaculoServico es;
		BandaServico bs;
		ParticipacaoServico ps;

		do {
			System.out.println("\n01 - Cadastrar um novo espetáculo e as participações dele");
			System.out.println("\n02 - Mostrar os dados de um espetáculo (nome, preço total e participações)");
			System.out.println("\n 3 - Sair");
			System.out.println("Digite uma opção: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
			case 1:
				System.out.println("Digite o nome do espetaculo a ser cadastrado: ");
				String nome = sc.nextLine();
				Espetaculo esp = new Espetaculo(null, nome);
				es = ServicoFactory.criarEspetucaloServico();
				es.inserirAtualizar(esp);

				System.out.println("\nQuantas participacoes este espetaculo vai ter? ");
				int N = Integer.parseInt(sc.nextLine());

				bs = ServicoFactory.criarBandaServico();
				List<Banda> listaBandas = bs.buscarTodos();
				System.out.println("\nBandas existentes: ");
				for (Banda x : listaBandas) {
					System.out.println(x);
				}

				ps = ServicoFactory.criarParticipacaoServico();

				for (int i = 1; i <= N; i++) {
					System.out.println("Digite o código da " + i + "a. banda do espetaculo: ");
					int cod = Integer.parseInt(sc.nextLine());
					Banda banda = bs.buscar(cod);
					Participacao part = new Participacao(null, i, banda, esp);
					ps.inserirAtualizar(part);
				}

				break;
			case 2:

				System.out.println("Digite o codigo do espetaculo a ser buscado:");
				int codEsp = Integer.parseInt(sc.nextLine());
				es = ServicoFactory.criarEspetucaloServico();
				Espetaculo espetaculo = es.buscar(codEsp);
				
				if(espetaculo == null){
					System.out.println("Código Inexistente!");
				}else{
					System.out.println("Nome: " + espetaculo.getNome());
					System.out.println("Preço total: R$ " + espetaculo.precoTotal());
					System.out.println("Participacoes: ");
					for(Participacao x : espetaculo.getParticipacoes()){
						System.out.println(x.getOrdem()+": " + x.getBanda().getNome());
					}
				}
				
				break;

			case 3:
				System.out.println("Fim do programada!");

			default:
				System.out.println("Opção inválida!");
			}

		} while (op != 3);

	}
}
