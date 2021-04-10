package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.ClienteVO;

public class ControladoraCliente {

	ClienteBO clienteBO = new ClienteBO();

	public String cadastrarClienteController(ClienteVO clienteVO) {
		return clienteBO.cadastrarClienteBO(clienteVO);
	}

	public String atualizarClienteController(ClienteVO clienteVO) {
		return clienteBO.atualizarClienteBO(clienteVO);
	}

	public String excluirClienteController(ClienteVO clienteVO) {
		return clienteBO.excluirClienteBO(clienteVO);
	}

	public ArrayList<ClienteVO> consultarTodosClientesController() {
		return clienteBO.consultarTodosClientesBO();
	}

	public ClienteVO consultarUmClienteController(ClienteVO clienteVO) {
		return clienteBO.consultarUmClienteBO(clienteVO);
	}
}
