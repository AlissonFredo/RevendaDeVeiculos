package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {

	public String cadastrarClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.verficarCliente(clienteVO.getCpf())) {
			retorno = "\n CLIENTE JÁ CADASTRADO!";
		} else {
			int resultado = clienteDAO.cadastrarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\n CLIENTE CADASTRADO COM SUCESSO!";
			} else {
				retorno = "\n NÃO FOI POSSIVEL CADASTRAR O CLIENTE!";
			}
		}
		return retorno;
	}

	public String atualizarClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.verificarClientePorId(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.atualizarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\n CLIENTE ATUALIZADO COM SUCESSO";
			} else {
				retorno = "\n NÃO FOI POSSÍVEL ATUALIZAR CLIENTE!";
			}
		} else {
			retorno = "\n CLIENTE NÃO ESTÁ REGISTRADO NO BANCO!";
		}
		return retorno;
	}

	public String excluirClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.verificarClientePorId(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.excluirClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\n CLIENTE EXCLUIDO COM SUCESSO!";
			} else {
				retorno = "\n NÃO FOI POSSIVEL EXCLUIR CLIENTE!";
			}
		} else {
			retorno = "\n CLIENTE NÃO ENCONTRADO NO BANCO!";
		}
		return retorno;
	}

	public ClienteVO consultarUmClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarUmClienteDAO(clienteVO);
	}

	public ArrayList<ClienteVO> consultarTodosClientesBO() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarTodosClientesDAO();
	}

}
