package controller;

import java.util.ArrayList;

import model.bo.VeiculoBO;
import model.vo.VeiculoVO;

public class ControladoraVeiculo {

	VeiculoBO veiculoBO = new VeiculoBO();

	public String cadastrarVeiculoController(VeiculoVO veiculoVO) {
		return veiculoBO.cadastrarVeiculoBO(veiculoVO);
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosController() {
		return veiculoBO.consultarTodosVeiculosBO();
	}

	public VeiculoVO consultarUmVeiculoControler(VeiculoVO veiculoVO) {
		return veiculoBO.consultarVeiculoBO(veiculoVO);
	}

	public String atualizarVeiculoController(VeiculoVO veiculoVO) {
		return veiculoBO.atualizarVeiculoBO(veiculoVO);
	}

	public String excluirVeiculoController(VeiculoVO veiculoVO) {
		return veiculoBO.excluirVeiculoBO(veiculoVO);
	}

}
