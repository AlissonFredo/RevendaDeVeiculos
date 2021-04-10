package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class VeiculoDAO {

	public boolean verificarVeiculoPorPlaca(String placa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT IDVEICULO FROM VEICULO WHERE PLACA = '" + placa + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query que consulta veiculo por placa!");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarVeiculoDAO(VeiculoVO veiculoVO) {
		int resultado = 0;
		String query = "INSERT INTO VEICULO (MODELO, TIPO, FABRICANTE, ANO, COR, PLACA) VALUES ('"
				+ veiculoVO.getModelo() + "','" + veiculoVO.getTipo() + "','" + veiculoVO.getFabricante() + "','"
				+ veiculoVO.getAno() + "','" + veiculoVO.getCor() + "','" + veiculoVO.getPlaca() + "')";
		try (Connection conn = Banco.getConnection(); Statement stmt = Banco.getStatement(conn);) {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar query que cadastra veiculo!");
		}
		return resultado;
	}

	public boolean verificarVeiculoPorId(int idVeiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT IDVEICULO FROM VEICULO WHERE IDVEICULO = '" + idVeiculo + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query que consulta veiculo por id!");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirVeiculo(VeiculoVO veiculoVO) {
		int resultado = 0;
		String query = "DELETE FROM VEICULO WHERE IDVEICULO = " + veiculoVO.getIdVeiculo() + ";";
		try (Connection conn = Banco.getConnection(); Statement stmt = Banco.getStatement(conn);) {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executar a query de excluir veiculo!");
		}
		return resultado;
	}

	public int atualizarVeiculo(VeiculoVO veiculoVO) {
		int resultado = 0;
		String query = "UPDATE VEICULO SET MODELO = '" + veiculoVO.getModelo() + "', TIPO = '" + veiculoVO.getTipo()
				+ "', FABRICANTE = '" + veiculoVO.getFabricante() + "', ANO = '" + veiculoVO.getAno() + "', COR = '"
				+ veiculoVO.getCor() + "', PLACA = '" + veiculoVO.getPlaca() + "' WHERE IDVEICULO ="
				+ veiculoVO.getIdVeiculo();
		try (Connection conn = Banco.getConnection(); Statement stmt = Banco.getStatement(conn);) {
			resultado = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro ao executer a query de atualizar veiculo!");
		}
		return resultado;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM VEICULO";
		ArrayList<VeiculoVO> lista = null;
		try {
			resultado = stmt.executeQuery(query);
			lista = new ArrayList<VeiculoVO>();
			while (resultado.next()) {
				VeiculoVO veiculo = new VeiculoVO();
				veiculo.setIdVeiculo(Integer.parseInt(resultado.getString("IDVEICULO")));
				veiculo.setModelo(resultado.getString("MODELO"));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString("TIPO")));
				veiculo.setFabricante(resultado.getString("FABRICANTE"));
				veiculo.setAno(resultado.getInt("ANO"));
				veiculo.setModelo(resultado.getString("MODELO"));
				veiculo.setCor(resultado.getString("COR"));
				veiculo.setPlaca(resultado.getString("PLACA"));
				lista.add(veiculo);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query de consultar todos os veicululos!");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	public VeiculoVO consultarUmVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM VEICULO WHERE IDVEICULO = " + veiculoVO.getIdVeiculo();
		VeiculoVO veiculo = new VeiculoVO();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				veiculo.setIdVeiculo(Integer.parseInt(resultado.getString("IDVEICULO")));
				veiculo.setModelo(resultado.getString("MODELO"));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString("TIPO")));
				veiculo.setFabricante(resultado.getString("FABRICANTE"));
				veiculo.setAno(resultado.getInt("ANO"));
				veiculo.setModelo(resultado.getString("MODELO"));
				veiculo.setCor(resultado.getString("COR"));
				veiculo.setPlaca(resultado.getString("PLACA"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar query de consultar um os veicululos!");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return veiculo;
	}

}
