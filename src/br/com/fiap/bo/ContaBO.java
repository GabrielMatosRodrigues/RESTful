package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.to.ContaTO;

public class ContaBO {
	private static ContaBO contaBo;
	private static ArrayList<ContaTO> lista = null;

	public static ContaBO getInstance() {
		if (contaBo == null) {
			contaBo = new ContaBO();
		}
		
		return contaBo;
	}

	public ContaBO() {
		lista = new ArrayList<ContaTO>();
		lista.add(new ContaTO(401, "Arnaldo da Silva Sauro", 56.79));
		lista.add(new ContaTO(402, "Beatriz Fonseca", 14500.67));
		lista.add(new ContaTO(403, "Pedro Diniz Maria", 6.66));
		lista.add(new ContaTO(404, "Elvis Presley",  25000.00));
	}

	public List<ContaTO> listar() {
		return lista;
	}

	public void cadastrar(ContaTO conta) {
		lista.add(conta);
	}

	public void remover(int codigo) {
		for(ContaTO conta : lista) {
			if(conta.getCodConta()==codigo) {
				lista.remove(conta);
			}
		}
	}

	public ContaTO buscar(int codigo) {
		for(ContaTO conta : lista) {
			if(conta.getCodConta()==codigo) {
				return conta;
			}
		}
		return null;
	}
	

	
	
}
