package model.bo;

import java.util.ArrayList;

import model.vo.VendaVO;

public class VendaBO {

	VendaDAO vendaDAO = new VendaDAO();

	public String cadastrarVendaBO(VendaVO vendaVO) {
		vendaDAO.cadastrarVendaDAO(vendaVO);
		return null;
	}

	public String atualizarVendaBO(VendaVO vendaVO) {
		vendaDAO.atualizarVendaBO(vendaVO);
		return null;
	}

	public String excluirVendaBO(VendaVO vendaVO) {
		vendaDAO.excluirVendaDAO(vendaVO.getIdVenda());
		return null;
	}

	public ArrayList<VendaVO> consultarTodasVendasBO() {

		return vendaDAO.consultarTodasVendasDAO();
	}

	public VendaVO consultarUmaVendaBO(VendaVO vendaVO) {
		return vendaDAO.consultarUmaVendaDAO(vendaVO);
	}

}
