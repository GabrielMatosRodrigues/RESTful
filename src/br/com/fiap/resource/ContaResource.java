package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ContaBO;
import br.com.fiap.to.ContaTO;

@Path("/conta")
public class ContaResource {
	private ContaBO contaBo = ContaBO.getInstance();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContaTO> buscar() {
		return contaBo.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ContaTO conta, @Context UriInfo uriInfo) {
		contaBo.cadastrar(conta);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(conta.getCodConta()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ContaTO buscar(@PathParam("id") int codigo) {
		return contaBo.buscar(codigo);
		
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		contaBo.remover(codigo);
	}
}
