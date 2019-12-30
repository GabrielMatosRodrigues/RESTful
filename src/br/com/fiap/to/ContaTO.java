package br.com.fiap.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContaTO implements Serializable {
	private int codConta;
	private String nome;
	private double saldo;
	
	public ContaTO(int codConta, String nome, double saldo) {
		super();
		this.codConta = codConta;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public ContaTO(String nome, double saldo) {
		super();
		this.codConta = codConta;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public ContaTO() {
		super();
	}

	public int getCodConta() {
		return codConta;
	}

	public void setCodConta(int codConta) {
		this.codConta = codConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
