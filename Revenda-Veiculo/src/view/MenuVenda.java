package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraVenda;
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
		VendaVO vendaVO = new VendaVO();
		System.out.print("\nDigite o codigo da venda: ");
		vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));

		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.excluirVendaController(vendaVO);
		System.out.println(resultado);
	}

	private void atualizarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.print("\nDigite o codigo da venda: ");
		vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o codigo do cliente: ");
		vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o codigo do veiculo: ");
		vendaVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o valor da venda: ");
		vendaVO.setValorVenda(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data da venda: ");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));

		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.atualizarVendaController(vendaVO);
		System.out.println(resultado);
	}

	private void consultarVenda() {
		int opcao = this.apresentarMenuConsultaVenda();
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		while (opcao != OPCAO_MENU_CONSULTA_VENDAS_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTA_TODAS_VENDAS: {
				opcao = OPCAO_MENU_CONSULTA_VENDAS_VOLTAR;
				ArrayList<VendaVO> listaVendaVO = controladoraVenda.consultarTodasVendasController();
				System.out.println("|| Resultado da consulta ||");
				for (int i = 0; i < listaVendaVO.size(); i++) {
					System.out.println(listaVendaVO.get(i).toString());
				}
				System.out.println();
				break;
			}
			case OPCAO_MENU_CONSULTA_UMA_VENDA: {
				VendaVO vendaVO = new VendaVO();
				System.out.print("\nDigite o codigo da venda: ");
				vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));

				VendaVO venda = controladoraVenda.consultarUmaVendaController(vendaVO);
				System.out.println("|| Resultado da consulta ||");
				if (venda == null) {
					System.out.println("Não foi possivel encontrar cliente");
				} else {
					System.out.println(venda.toString());
				}
			}
			default: {
				System.err.println("Opção invalida!");
				this.apresentarMenuConsultaVenda();
			}
			}
		}
	}

	private int apresentarMenuConsultaVenda() {
		System.out.println("\n|| Opções de consulta ||");
		System.out.println(OPCAO_MENU_CONSULTA_TODAS_VENDAS + " - Consultar todas as vendas");
		System.out.println(OPCAO_MENU_CONSULTA_UMA_VENDA + " - Consultar uma venda");
		System.out.println(OPCAO_MENU_CONSULTA_VENDAS_VOLTAR + " - Voltar");
		System.out.print("Digite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.print("\nDigite o codigo do cliente: ");
		vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o codigo do veiculo: ");
		vendaVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o valor da venda: ");
		vendaVO.setValorVenda(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data da venda: ");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));

		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.cadastrarVendaController(vendaVO);
		System.out.println(resultado);
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
