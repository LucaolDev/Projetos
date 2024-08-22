package estudos;

import java.util.Scanner;

public class ProjetoAgenda {

	public static Scanner in = new Scanner(System.in);
	public static String agenda[][] = new String[10][3];

	public static void LimparMatriz(String mm[][]) {

		for (int l = 0; l < 10; l++) {
			for (int c = 0; c < 3; c++) {
				mm[l][c] = "";
			}
		}
	}

	public static void novo(String mm[][], int l) {

		System.out.println("------------ PREENCHA O NOVO CONTATO: ");
		System.out.print("Nome.........: ");
		mm[l][0] = in.next();
		System.out.print("Celular......: ");
		mm[l][1] = in.next();
		System.out.print("E-mail.......: ");
		mm[l][2] = in.next();
	}

	public static void editarContato(String mm[][], int l) {

		System.out.println("-------------- EDITE O CONTATO: ");
		System.out.print("Nome........: ");
		mm[l][0] = in.next();
		System.out.print("Celular.....: ");
		mm[l][1] = in.next();
		System.out.print("E-mail......: ");
		mm[l][2] = in.next();
	}

	public static int linhaProximoContato(String mm[][]) {
		for (int l = 0; l < 10; l++) {
			if (mm[l][0].equals("")) {
				return l;
			}
		}
		return -1;
	}

	public static void exibirContato(String mm[][], int linha) {
		System.out.println("Nome.......: " + mm[linha][0]);
		System.out.println("Celular....: " + mm[linha][1]);
		System.out.println("E-mail.....: " + mm[linha][2]);
	}

	public static void listarAgenda(String mm[][]) {
		System.out.println("--------- CONTATOS DA AGENDA: ");
		for (int l = 0; l < 10; l++) {
			if (mm[l][0] != "") {
				exibirContato(mm, l);
				System.out.println("-------------------");
			}
		}
		System.out.println("---------- FIM DA AGENDA: ");
	}

	public static int pesquisarContato(String mm[][], String n) {
		for (int l = 0; l < 10; l++) {
			if (mm[l][0].equals(n)) {
				return l;
			}
		}
		return -1;
	}

	public static void excluiLinha(String mm[][], int l) {
		mm[l][0] = "";
		mm[l][1] = "";
		mm[l][2] = "";
		System.out.println("Contato Excluido");
	}

	public static void apagarContato(String mm[][], String n) {

		boolean achou = false;
		int linha = pesquisarContato(mm, n);
		String opcao;

		if (linha != -1) {
			exibirContato(mm, linha);
			System.out.println("Confirma a exclusão do contato? [S]im ou [N]ão? ");
			opcao = in.next();

			if (opcao.equals("s") || opcao.equals("S")) {
				excluiLinha(mm, linha);
			} else {
				System.out.println("Exclusão Cancelada!");
			}
		} else {
			System.out.println("Contato não encontrado! ");
		}
	}

	public static void exibeMenu() {
		System.out.println("********* M E N U ********");
		System.out.println("1 - Adicionar novo contato");
		System.out.println("2 - Editar contato");
		System.out.println("3 - Pesquisar contato");
		System.out.println("4 - Lista de contatos");
		System.out.println("5 - Apagar um contato");
		System.out.println("6 - Sair");
	}

	public static void main(String[] args) {
		int opcao, linha;
		String nome;

		LimparMatriz(agenda);

		do {
			exibeMenu();
			System.out.print("Escolha uma opção:");
			opcao = in.nextInt();
			System.out.println();

			switch (opcao) {

			case 1:
				novo(agenda, linhaProximoContato(agenda));
				break;

			case 2:
				System.out.println("------------ EDITANDO (PESQUISE O CONTATO): ");
				System.out.print("Digite o nome.........:");
				nome = in.next();
				linha = pesquisarContato(agenda, nome);
				if (linha == -1) {

					System.out.print("Contato não Cadastrado!");
				} else {

					exibirContato(agenda, linha);
					editarContato(agenda, linha);
				}
				break;

			case 3:

				System.out.println("------------ PESQUISE O CONTATO: ");
				System.out.print("Digite o nome.........:");
				nome = in.next();

				linha = pesquisarContato(agenda, nome);
				if (linha == -1) {

					System.out.print("Contato não Cadastrado!");
				} else {

					exibirContato(agenda, linha);
				}
				break;

			case 4:
				listarAgenda(agenda);
				break;

			case 5:

				System.out.println("------------ EXCLUINDO (PESQUISE O CONTATO): ");
				System.out.print("Digite o nome.........:");
				nome = in.next();
				apagarContato(agenda, nome);
				break;

			case 6:
				System.out.print("OBRIGADO POR UTILIZAR A NOSSA AGENDA ");

			}
			System.out.println();
		} while (opcao != 6);
	}
}
