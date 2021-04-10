package model.bo;

import java.util.ArrayList;

import model.dao.VeiculoDAO;
import model.vo.VeiculoVO;

public class VeiculoBO {

	VeiculoDAO veiculoDAO = new VeiculoDAO();

	public String cadastrarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		if (veiculoDAO.verificarVeiculoPorPlaca(veiculoVO.getPlaca())) {
			retorno = "\nVeiculo ja cadastrado no banco!";
		} else {
			int resultado = veiculoDAO.cadastrarVeiculoDAO(veiculoVO);
			if (resultado == 1) {
				retorno = "\nVeiculo cadastrado com sucesso!";
			} else {
				retorno = "\nNão foi possivel cadastrar o vaiculo!";
			}
		}
		return retorno;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosBO() {
		return veiculoDAO.consultarTodosVeiculosDAO();
	}

	public VeiculoVO consultarVeiculoBO(VeiculoVO veiculoVO) {
		return veiculoDAO.consultarUmVeiculoDAO(veiculoVO);
	}

	public String atualizarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		if (veiculoDAO.verificarVeiculoPorId(veiculoVO.getIdVeiculo())) {
			int resultado = veiculoDAO.atualizarVeiculo(veiculoVO);
			if (resultado == 1) {
				retorno = "\nVeiculo atualizado!";
			} else {
				retorno = "\nNão foi possivel atualizar veiculo";
			}
		} else {
			retorno = "\nVeiculo não esta registrado no banco";
		}
		return retorno;
	}

	public String excluirVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		if (veiculoDAO.verificarVeiculoPorId(veiculoVO.getIdVeiculo())) {
			int resultado = veiculoDAO.excluirVeiculo(veiculoVO);
			if (resultado == 1) {
				retorno = "\nVeiculo excluido";
			} else {
				retorno = "\nVeiculo não encontrado no banco";
			}
		} else {
			retorno = "\nVeiculo não encontrado no banco";
		}
		return retorno;
	}
}
