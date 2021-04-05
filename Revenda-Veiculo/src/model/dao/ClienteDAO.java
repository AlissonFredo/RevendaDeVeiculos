package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ClienteVO;

public class ClienteDAO {

	public int cadastrarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO cliente (nome, cpf, telefone) VALUES ('" + clienteVO.getNome() + "', '"
				+ clienteVO.getCpf() + "', '" + clienteVO.getTelefone() + "')";

		try {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query de cadastro do cliente!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE cliente SET nome = '" + clienteVO.getNome() + "', cpf = '" + clienteVO.getCpf()
				+ "', telefone = '" + clienteVO.getTelefone() + "'WHERE idcliente = '" + clienteVO.getIdCliente();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query de atualização do cliente!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM cliente WHERE idcliente = " + clienteVO.getIdCliente();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query de exclusão do cliente!");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ClienteVO consultarUmClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVO cliente = new ClienteVO();
		String query = "SELECT * FROM cliente WHERE idcliente = " + clienteVO.getIdCliente();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				cliente.setIdCliente(resultado.getInt("idcliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setTelefone(resultado.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de cliente!");
		}
		return cliente;
	}

	public ArrayList<ClienteVO> consultarTodosClientesDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVO> listaClientes = new ArrayList<>();
		String query = "SELECT * FROM cliente";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(resultado.getInt("idcliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setTelefone(resultado.getString("telefone"));
				listaClientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query para consulta de cliente!");
		}
		return listaClientes;
	}

	public boolean verficarCliente(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idcliente FROM cliente WHERE cpf = '" + cpf + "'";

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
		String query = "SELECT idcliente FROM cliente WHERE idcliente = " + idCliente;

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
