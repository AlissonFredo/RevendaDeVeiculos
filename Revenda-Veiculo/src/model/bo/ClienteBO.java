package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {

	ClienteDAO clienteDAO = new ClienteDAO();

	public String cadastrarClienteBO(ClienteVO clienteVO) {
		String retorno;
		if (clienteDAO.verficarCliente(clienteVO.getCpf())) {
			retorno = "\nCliente ja cadastrado!";
		} else {
			int resultado = clienteDAO.cadastrarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente cadastrado com sucesso!";
			} else {
				retorno = "\nNão foi possivel cadastrar o cliente!";
			}
		}
		return retorno;
	}

	public String atualizarClienteBO(ClienteVO clienteVO) {
		String retorno;
		if (clienteDAO.verificarClientePorId(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.atualizarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente atualizado com sucesso";
			} else {
				retorno = "\nNão foi possivel atualizar cliente!";
			}
		} else {
			retorno = "\nCliente não está registrado no banco!";
		}
		return retorno;
	}

	public String excluirClienteBO(ClienteVO clienteVO) {
		String retorno;
		if (clienteDAO.verificarClientePorId(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.excluirClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente excluido com sucesso!!";
			} else {
				retorno = "\nNão foi possivel excluir cliente!";
			}
		} else {
			retorno = "\nCliente não encontrado no banco!";
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
