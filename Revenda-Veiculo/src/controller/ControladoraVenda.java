package controller;

import java.util.ArrayList;

import model.bo.VendaBO;
import model.vo.VendaVO;

public class ControladoraVenda {

	VendaBO vendaBO = new VendaBO();

	public String cadastrarVendaController(VendaVO vendaVO) {
		return vendaBO.cadastrarVendaBO(vendaVO);
	}

	public String atualizarVendaController(VendaVO vendaVO) {
		return vendaBO.atualizarVendaBO(vendaVO);
	}

	public String excluirVendaController(VendaVO vendaVO) {
		return vendaBO.excluirVendaBO(vendaVO);
	}

	public ArrayList<VendaVO> consultarTodasVendasController() {
		return vendaBO.consultarTodasVendasBO();
	}

	public VendaVO consultarUmaVendaController(VendaVO vendaVO) {
		return vendaBO.consultarUmaVendaBO(vendaVO);
	}

}
