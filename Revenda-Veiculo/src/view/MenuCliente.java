package view;

import java.util.Scanner;

import model.vo.ClienteVO;

public class MenuCliente {

	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_CLIENTE_CADASTRAR = 1;
	private static final int OPCAO_MENU_CLIENTE_CONSULTAR = 2;
	private static final int OPCAO_MENU_CLIENTE_ATUALIZAR = 3;
	private static final int OPCAO_MENU_CLIENTE_EXCLUIR = 4;
	private static final int OPCAO_MENU_CLIENTE_VOLTAR = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODOS_CLIENTES = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_CLIENTE = 2;
	private static final int OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR = 3;

	public void apresentarMenuCliente() {
		int opcao = this.apresentarOpcoesMenuCliente();
		while (opcao != OPCAO_MENU_CLIENTE_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CLIENTE_CADASTRAR: {
				this.cadastrarCliente();
				break;
			}
			case OPCAO_MENU_CLIENTE_CONSULTAR: {
				this.consultarCliente();
				break;
			}
			case OPCAO_MENU_CLIENTE_ATUALIZAR: {
				this.atualizasCliente();
				break;
			}
			case OPCAO_MENU_CLIENTE_EXCLUIR: {
				this.excluirCliente();
				break;
			}
			default: {
				System.out.println("OPÇÃO INVÁLIDA");
			}
			}
			opcao = this.apresentarOpcoesMenuCliente();
		}
	}

	private int apresentarOpcoesMenuCliente() {
		System.out.println();
		System.out.println("******************");
		System.out.println("|| MENU CLIENTE ||");
		System.out.println("******************");
		System.out.println(OPCAO_MENU_CLIENTE_CADASTRAR + " - CADASTRAR CLIENTE");
		System.out.println(OPCAO_MENU_CLIENTE_CONSULTAR + " - CONSULTAR CLIENTE");
		System.out.println(OPCAO_MENU_CLIENTE_ATUALIZAR + " - ATUALIZAR CLIENTE");
		System.out.println(OPCAO_MENU_CLIENTE_EXCLUIR + " - EXCLUIR CLIENTE");
		System.out.println(OPCAO_MENU_CLIENTE_VOLTAR + " - VOLTAR");
		System.out.print("\nDIGITE A OPÇÃO: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("DIGITE O NOME DO CLIENTE: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("DIGITE O CPF DO CLIENTE: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("DIGITE O TELEFONE DO CLIENTE: ");
		clienteVO.setTelefone(teclado.nextLine());
	}

	private void consultarCliente() {
		int opcao = this.apresentarOpcoesConsultarCliente();
	}

	private int apresentarOpcoesConsultarCliente() {
		System.out.println("------ OPÇÕES DE CONSULTA CLIENTE ------");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_CLIENTES + " - CONSULTAR TODOS CLIENTES");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_CLIENTE + " - CONSULTAR UM CLIENTE");
		System.out.println(OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR + " - VOLTAR");
		int opcao = Integer.parseInt(teclado.nextLine());
		return opcao;
	}

	private void atualizasCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("DIGITE O CÓDIGO DO CLIENTE: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.println("DIGITE O NOME DO CLIENTE: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("DIGITE O CPF DO CLIENTE: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("DIGITE O TELEFONE DO CLIENTE: ");
		clienteVO.setTelefone(teclado.nextLine());
	}

	private void excluirCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("DIGITE O CÓDIGO DO CLIENTE: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
	}

}
