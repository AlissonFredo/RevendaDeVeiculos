package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ClienteVO;

public class ClienteDAO {

	public int cadastrarClienteDAO(ClienteVO clienteVO) {
		int resultado = 0;
		String query = "INSERT INTO CLIENTE (NOME, CPF, TELEFONE) VALUES ('" + clienteVO.getNome() + "', '"
				+ clienteVO.getCpf() + "', '" + clienteVO.getTelefone() + "')";

		try (Connection conn = Banco.getConnection(); Statement stmt = Banco.getStatement(conn);) {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query de cadastro do cliente!");
		}
		return resultado;
	}

	public int atualizarClienteDAO(ClienteVO clienteVO) {
		int resultado = 0;
		String query = "UPDATE CLIENTE SET NOME = '" + clienteVO.getNome() + "', CPF = '" + clienteVO.getCpf()
				+ "', TELEFONE = '" + clienteVO.getTelefone() + "' WHERE IDCLIENTE = " + clienteVO.getIdCliente();
		try (Connection conn = Banco.getConnection(); Statement stmt = Banco.getStatement(conn);) {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query de atualização do cliente!");
		}
		return resultado;
	}

	public int excluirClienteDAO(ClienteVO clienteVO) {
		int resultado = 0;
		String query = "DELETE FROM CLIENTE WHERE IDCLIENTE = " + clienteVO.getIdCliente();
		try (Connection conn = Banco.getConnection(); Statement stmt = Banco.getStatement(conn);) {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query de exclusão do cliente!");
		}
		return resultado;
	}

	public ClienteVO consultarUmClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVO cliente = new ClienteVO();
		String query = "SELECT * FROM CLIENTE WHERE IDCLIENTE = " + clienteVO.getIdCliente();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				cliente.setIdCliente(resultado.getInt("IDCLIENTE"));
				cliente.setNome(resultado.getString("NOME"));
				cliente.setCpf(resultado.getString("CPF"));
				cliente.setTelefone(resultado.getString("TELEFONE"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de um cliente!");
		}
		return cliente;
	}

	public ArrayList<ClienteVO> consultarTodosClientesDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVO> listaClientes = new ArrayList<>();
		String query = "SELECT * FROM CLIENTE";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(resultado.getInt("IDCLIENTE"));
				cliente.setNome(resultado.getString("NOME"));
				cliente.setCpf(resultado.getString("CPF"));
				cliente.setTelefone(resultado.getString("TELEFONE"));
				listaClientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de todos os clientes!");
		}
		return listaClientes;
	}

	public boolean verficarCliente(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT IDCLIENTE FROM CLIENTE WHERE CPF = '" + cpf + "'";

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query que realiza consulta por CPF");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean verificarClientePorId(int idCliente) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT IDCLIENTE FROM CLIENTE WHERE IDCLIENTE = " + idCliente;

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query que realiza consulta por ID cliente");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
}
