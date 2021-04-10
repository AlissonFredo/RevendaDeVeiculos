package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraVeiculo;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class MenuVeiculo {
	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_VEICULO_CADASTRADO = 1;
	private static final int OPCAO_MENU_VEICULO_CONSULTAR = 2;
	private static final int OPCAO_MENU_VEICULO_ATUALIZAR = 3;
	private static final int OPCAO_MENU_VEICULO_EXCLUIR = 4;
	private static final int OPCAO_MENU_VEICULO_VOLTAR = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODOS_VEICULOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_VEICULO = 2;
	private static final int OPCAO_MENU_CONSULTAR_VEICULO_VOLTAR = 3;

	private static final int OPCAO_VEICULO_CARRO = 1;
	private static final int OPCAO_VEICULO_MOTO = 2;
	private static final int OPCAO_VEICULO_SUV = 3;
	private static final int OPCAO_VEICULO_SAIR = 99;

	public void apresentarMenuVeiculo() {
		int opcao = this.apresentarOpcoesMenuVeiculo();
		while (opcao != OPCAO_MENU_VEICULO_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_VEICULO_CADASTRADO: {
				this.cadastrarVeiculo();
				break;
			}
			case OPCAO_MENU_VEICULO_CONSULTAR: {
				this.consultarVeiculo();
				break;
			}
			case OPCAO_MENU_VEICULO_ATUALIZAR: {
				this.atualizarVeiculo();
				break;
			}
			case OPCAO_MENU_VEICULO_EXCLUIR: {
				this.excluirVeiculo();
				break;
			}
			default: {
				System.out.println("Opção invalida");
			}
			}
			opcao = this.apresentarOpcoesMenuVeiculo();
		}
	}

	private void excluirVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o codigo do veiculo: ");
		veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));

		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.excluirVeiculoController(veiculoVO);
		System.out.println(resultado);
		System.out.println();
	}

	private void atualizarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o id do veiculo:");
		veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o modelo do veiculo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.println("Digite o tipo do veiculo");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while (opcao != OPCAO_VEICULO_SAIR) {
			switch (opcao) {
			case OPCAO_VEICULO_CARRO: {
				opcao = OPCAO_VEICULO_SAIR;
				veiculoVO.setTipo(TipoVeiculo.CARRO);
				break;
			}
			case OPCAO_VEICULO_MOTO: {
				opcao = OPCAO_VEICULO_SAIR;
				veiculoVO.setTipo(TipoVeiculo.MOTO);
				break;
			}
			case OPCAO_VEICULO_SUV: {
				opcao = OPCAO_VEICULO_SAIR;
				veiculoVO.setTipo(TipoVeiculo.SUV);
				break;
			}
			default: {
				System.out.println("\nOpção invalida!");
				opcao = this.apresentarOpcoesTipoVeiculo();
			}
			}
		}
		System.out.print("\nDigite o fabricante do veiculo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("\nDigite o ano do veiculo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a cor do veiculo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.print("\nDigite a placa do veiculo: ");
		veiculoVO.setPlaca(teclado.nextLine());

		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.atualizarVeiculoController(veiculoVO);
		System.out.println(resultado);
		System.out.println();
	}

	private void consultarVeiculo() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		while (opcao != OPCAO_MENU_CONSULTAR_VEICULO_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTAR_TODOS_VEICULOS: {
				opcao = OPCAO_MENU_CONSULTAR_VEICULO_VOLTAR;
				ArrayList<VeiculoVO> listaVeiculoVO = controladoraVeiculo.consultarTodosVeiculosController();
				if (listaVeiculoVO.isEmpty()) {
					System.out.println("Não foi encontrada a lista");
				}
				System.out.println("Resultado da consulta");
				for (int i = 0; i < listaVeiculoVO.size(); i++) {
					System.out.println(listaVeiculoVO.get(i).toString());
				}
				break;
			}
			case OPCAO_MENU_CONSULTAR_UM_VEICULO: {
				opcao = OPCAO_MENU_CONSULTAR_VEICULO_VOLTAR;
				VeiculoVO veiculoVO = new VeiculoVO();
				System.out.print("\nDigite o codigo do veiculo: ");
				veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));

				VeiculoVO veiculo = controladoraVeiculo.consultarUmVeiculoControler(veiculoVO);
				if (veiculo.getPlaca() == null) {
					System.out.println("Não foi encontrado veiculo!");
				} else {
					System.out.println("Resultado da consulta");
					System.out.println(veiculo.toString());
				}
				System.out.println();
				break;
			}
			default: {
				System.out.println("Opção invalida");
			}
			}
		}

	}

	private int apresentarOpcoesMenuConsulta() {
		System.out.println("Opções de consulta");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_VEICULOS + " - Consultar todos veiculos");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_VEICULO + " - Consultar um veiculo");
		System.out.println(OPCAO_MENU_CONSULTAR_VEICULO_VOLTAR + " - Voltar");
		System.out.print("Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o modelo do veiculo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.println("Digite o tipo do veiculo");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while (opcao != OPCAO_VEICULO_SAIR) {
			switch (opcao) {
			case OPCAO_VEICULO_CARRO: {
				opcao = OPCAO_VEICULO_SAIR;
				veiculoVO.setTipo(TipoVeiculo.CARRO);
				break;
			}
			case OPCAO_VEICULO_MOTO: {
				opcao = OPCAO_VEICULO_SAIR;
				veiculoVO.setTipo(TipoVeiculo.MOTO);
				break;
			}
			case OPCAO_VEICULO_SUV: {
				opcao = OPCAO_VEICULO_SAIR;
				veiculoVO.setTipo(TipoVeiculo.SUV);
				break;
			}
			default: {
				System.out.println("\nOpção invalida!");
				opcao = this.apresentarOpcoesTipoVeiculo();
			}
			}
		}
		System.out.print("\nDigite o fabricante do veiculo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("\nDigite o ano do veiculo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a cor do veiculo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.print("\nDigite a placa do veiculo: ");
		veiculoVO.setPlaca(teclado.nextLine());

		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.cadastrarVeiculoController(veiculoVO);
		System.out.println(resultado);
		System.out.println();
	}

	private int apresentarOpcoesTipoVeiculo() {
		System.out.println("Opções");
		System.out.println(OPCAO_VEICULO_CARRO + " - Carro");
		System.out.println(OPCAO_VEICULO_MOTO + " - Moto");
		System.out.println(OPCAO_VEICULO_SUV + " - Suv");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private int apresentarOpcoesMenuVeiculo() {
		System.out.println();
		System.out.println("*****************");
		System.out.println("|| MENU VEICULO ||");
		System.out.println("*****************");
		System.out.println("\n opções");
		System.out.println(OPCAO_MENU_VEICULO_CADASTRADO + " - cadastrar veiculo");
		System.out.println(OPCAO_MENU_VEICULO_CONSULTAR + " - consultar veiculo");
		System.out.println(OPCAO_MENU_VEICULO_ATUALIZAR + " - atualizar veiculo");
		System.out.println(OPCAO_MENU_VEICULO_EXCLUIR + " - excluir veiculo");
		System.out.println(OPCAO_MENU_VEICULO_VOLTAR + " - voltar");
		System.out.print("\ndigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
