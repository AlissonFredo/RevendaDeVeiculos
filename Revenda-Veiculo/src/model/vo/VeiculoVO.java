package model.vo;

public class VeiculoVO {

	private int idVeiculo;
	private String modelo;
	private TipoVeiculo tipo;
	private String fabricante;
	private int ano;
	private String cor;
	private String placa;

	public VeiculoVO() {
		super();
	}

	public VeiculoVO(int idVeiculo, String modelo, TipoVeiculo tipo, String fabricante, int ano, String cor,
			String placa) {
		super();
		this.idVeiculo = idVeiculo;
		this.modelo = modelo;
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.ano = ano;
		this.cor = cor;
		this.placa = placa;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo [idVeiculo=" + idVeiculo + ", modelo=" + modelo + ", tipo=" + tipo + ", fabricante="
				+ fabricante + ", ano=" + ano + ", cor=" + cor + ", placa=" + placa + "]";
	}
}
