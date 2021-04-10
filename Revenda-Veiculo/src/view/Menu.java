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
				System.out.println("Opção invalida");
			}
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}

	private int apresentarOpcoesMenu() {
		System.out.println("|| REVENDA FERRO VELHO ||");
		System.out.println("Opções");
		System.out.println(OPCAO_MENU_CLIENTE + " - Menu cliente");
		System.out.println(OPCAO_MENU_VEICULO + " - Menu veiculo");
		System.out.println(OPCAO_MENU_VENDA + " - Menu venda");
		System.out.println(OPCAO_MENU_RELATORIO + " - Menu relatorio");
		System.out.println(OPCAO_MENU_SAIR + " - sair");
		System.out.print("Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
