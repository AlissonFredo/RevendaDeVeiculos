package model.vo;

public class ClienteVO {
	
	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;

	public ClienteVO() {
		super();
	}

	public ClienteVO(int idCliente, String nome, String cpf, String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void imprimirCliente() {
		System.out.printf("%3d   %-8s   %-6s   %-10s \n"
				, this.getIdCliente()
				, this.getNome()
				, this.getCpf()
				, this.getTelefone());
	}
}
