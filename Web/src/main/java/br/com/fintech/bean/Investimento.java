package br.com.fintech.bean;

public class Investimento {
	private int codigoInvestimento;
	private int codigoUsuario;
	private String nome;
	private double valor;
	private String descricao;
	
	public Investimento() {
		super();
	}
	
	public Investimento(int codigoInv, int codigoUsu, String nome, double valor, String descricao) {
		super();
		this.codigoInvestimento = codigoInv;
		this.codigoUsuario = codigoUsu;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Investimento(int codigoInv, int codigoUsu, String nome, double valor) {
		super();
		this.codigoInvestimento = codigoInv;
		this.codigoUsuario = codigoUsu;
		this.nome = nome;
		this.valor = valor;
	}

	public int getCodigoInvestimento() {
		return codigoInvestimento;
	}

	public void setCodigoInvestimento(int codigoInvestimento) {
		this.codigoInvestimento = codigoInvestimento;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
