package view;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.vo.VendaVO;

public class MenuVenda {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int OPCAO_MENU_VENDA_CADASTRAR = 1;
	private static final int OPCAO_MENU_VENDA_CONSULTAR = 2;
	private static final int OPCAO_MENU_VENDA_ATUALIZAR = 3;
	private static final int OPCAO_MENU_VENDA_EXCLUIR = 4;
	private static final int OPCAO_MENU_VENDA_VOLTAR = 5;

	private static final int OPCAO_MENU_CONSULTA_TODAS_VENDAS = 1;
	private static final int OPCAO_MENU_CONSULTA_UMA_VENDA = 2;
	private static final int OPCAO_MENU_CONSULTA_VENDAS_VOLTAR = 3;

	public void apresentarMenuVenda() {
		int opcao = this.apresentarOpcaoMenuVenda();
		while (opcao != OPCAO_MENU_VENDA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_VENDA_CADASTRAR: {
				this.cadastrarVenda();
				break;
			}
			case OPCAO_MENU_VENDA_CONSULTAR: {
				this.consultarVenda();
				break;
			}
			case OPCAO_MENU_VENDA_ATUALIZAR: {
				this.atualizarVenda();
				break;
			}
			case OPCAO_MENU_VENDA_EXCLUIR: {
				this.excluirVenda();
				break;
			}
			default: {
				System.err.println("Opção invalida");
			}
			}
			opcao = this.apresentarOpcaoMenuVenda();
		}
	}

	private void excluirVenda() {
		// TODO Auto-generated method stub
		
	}

	private void atualizarVenda() {
		// TODO Auto-generated method stub
		
	}

	private void consultarVenda() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarVenda() {
		VendaVO vendaVO = new VendaVO(); 
	}

	private int apresentarOpcaoMenuVenda() {
		System.out.println("|| Menu venda ||");
		System.out.println(OPCAO_MENU_VENDA_CADASTRAR + " - Cadastrar venda");
		System.out.println(OPCAO_MENU_VENDA_CONSULTAR + " - Consultar venda");
		System.out.println(OPCAO_MENU_VENDA_ATUALIZAR + " - Atualizar venda");
		System.out.println(OPCAO_MENU_VENDA_EXCLUIR + " - Excluir venda");
		System.out.println(OPCAO_MENU_VENDA_VOLTAR + " - Voltar");
		System.out.print("Digite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

}
