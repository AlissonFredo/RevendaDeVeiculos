package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraCliente;
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
				System.err.println("Opção invalida");
			}
			}
			opcao = this.apresentarOpcoesMenuCliente();
		}
	}

	private int apresentarOpcoesMenuCliente() {
		System.out.println("\n|| MENU CLIENTE ||");
		System.out.println(OPCAO_MENU_CLIENTE_CADASTRAR + " - Cadastrar cliente");
		System.out.println(OPCAO_MENU_CLIENTE_CONSULTAR + " - Consultar cliente");
		System.out.println(OPCAO_MENU_CLIENTE_ATUALIZAR + " - Atualizar cliente");
		System.out.println(OPCAO_MENU_CLIENTE_EXCLUIR + " - Excluir cliente");
		System.out.println(OPCAO_MENU_CLIENTE_VOLTAR + " - Voltar");
		System.out.print("Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("\nDigite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.print("Digite o cpf do cliente: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.print("Digite o telefone do cliente: ");
		clienteVO.setTelefone(teclado.nextLine());

		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.cadastrarClienteController(clienteVO);
		System.out.println(resultado);
	}

	private void consultarCliente() {
		int opcao = this.apresentarOpcoesConsultarCliente();
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		while (opcao != OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTAR_TODOS_CLIENTES:
				opcao = OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR;
				ArrayList<ClienteVO> listaClienteVO = controladoraCliente.consultarTodosClientesController();
				if (listaClienteVO.isEmpty()) {
					System.out.println("Não foi possivel encontrar a lista de clientes");
				}
				System.out.println();
				System.out.println("Resultado da consulta");
				for (int i = 0; i < listaClienteVO.size(); i++) {
					System.out.println(listaClienteVO.get(i).toString());
				}
				System.out.println();
				break;
			case OPCAO_MENU_CONSULTAR_UM_CLIENTE:
				opcao = OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR;
				ClienteVO clienteVO = new ClienteVO();
				System.out.print("Digite o codigo do cliente: ");
				clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
				ClienteVO cliente = controladoraCliente.consultarUmClienteController(clienteVO);
				if (cliente == null) {
					System.out.println("Não foi possivel encontrar cliente");
				}
				System.out.println("Resultado da consulta");
				if (cliente != null) {
					System.out.println(cliente.toString());
				}
				System.out.println();
				break;
			default:
				System.err.println("Opção invalida");
				opcao = this.apresentarOpcoesConsultarCliente();
			}
		}
	}

	private int apresentarOpcoesConsultarCliente() {
		System.out.println("\n|| OPÇÕES DE CONSULTA CLIENTE ||");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_CLIENTES + " - Consultar todos clientes");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_CLIENTE + " - Consultar um cliente");
		System.out.println(OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR + " - voltar");
		System.out.print("Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void atualizasCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("Digite o codigo do cliente: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.print("Digite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.print("Digite o cpf do cliente: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.print("Digite o telefone do cliente: ");
		clienteVO.setTelefone(teclado.nextLine());

		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.atualizarClienteController(clienteVO);
		System.out.println(resultado);
	}

	private void excluirCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("Digite o codigo do cliente: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));

		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.excluirClienteController(clienteVO);
		System.out.println(resultado);
	}

}
