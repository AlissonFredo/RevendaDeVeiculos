package view;

import java.util.Scanner;

public class Menu {

	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_CLIENTE = 1;
	private static final int OPCAO_MENU_VEICULO = 2;
	private static final int OPCAO_MENU_VENDA = 3;
	private static final int OPCAO_MENU_RELATORIO = 4;
	private static final int OPCAO_MENU_SAIR = 5;

	public void apresentarMenu() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR) {
			switch (opcao) {
			case OPCAO_MENU_CLIENTE: {
				MenuCliente menuCliente = new MenuCliente();
				menuCliente.apresentarMenuCliente();
				break;
			}
			case OPCAO_MENU_VEICULO: {
				MenuVeiculo menuVeiculo = new MenuVeiculo();
				menuVeiculo.apresentarMenuVeiculo();
				break;
			}
			case OPCAO_MENU_VENDA: {
				break;
			}
			case OPCAO_MENU_RELATORIO: {
				break;
			}
			default: {
				System.out.println("OPÇÃO INVÁLIDA");
			}
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}

	private int apresentarOpcoesMenu() {
		System.out.println("*************************");
		System.out.println("|| REVENDA FERRO VELHO ||");
		System.out.println("*************************");
		System.out.println("\nOPÇÕES");
		System.out.println(OPCAO_MENU_CLIENTE + " - MENU CLIENTE");
		System.out.println(OPCAO_MENU_VEICULO + " - MENU VEÍCULO");
		System.out.println(OPCAO_MENU_VENDA + " - MENU VENDA");
		System.out.println(OPCAO_MENU_RELATORIO + " - MENU RELATÓRIO");
		System.out.println(OPCAO_MENU_SAIR + " - MENU SAIR");
		System.out.print("\nDIGITE A OPÇÃO: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
