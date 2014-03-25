package curso.integracion.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import curso.modelo.Usuario;

@WebService(serviceName = "holaEndpoint")
public class UsuarioWS {

	@WebMethod(operationName = "consultaUsuario")
	public Usuario consultaUsuario(String nombre) {
		Usuario u = new Usuario();
		u.setNombre(nombre);
		return u;
	}
}
