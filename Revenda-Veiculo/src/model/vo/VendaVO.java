package model.vo;

import java.time.LocalDate;

public class VendaVO {

	private int idVenda;
	private int idCliente;
	private int idVeiculo;
	private double valorVenda;
	private LocalDate dataVenda;

	public VendaVO(int idVenda, int idCliente, int idVeiculo, double valorVenda, LocalDate dataVenda) {
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		this.valorVenda = valorVenda;
		this.dataVenda = dataVenda;
	}

	public VendaVO() {
		super();
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public String toString() {
		return "VendaVO [idVenda=" + idVenda + ", idCliente=" + idCliente + ", idVeiculo=" + idVeiculo + ", valorVenda="
				+ valorVenda + ", dataVenda=" + dataVenda + "]";
	}
}
