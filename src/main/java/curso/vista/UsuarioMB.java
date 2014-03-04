package curso.vista;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.modelo.Ciudad;
import curso.modelo.Usuario;
import curso.negocio.CiudadBO;
import curso.negocio.UsuarioBO;

@Component
@ViewScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usr = new Usuario();

	@Autowired
	private UsuarioBO bo;

	@Autowired
	private CiudadBO ciudadBO;

	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public List<Usuario> getLista() {
		List<Usuario> ret = bo.listar();
		System.out.println("No. Usuarios:" + ret.size());
		return ret;
	}

	public List<Ciudad> getCiudades() {
		return ciudadBO.listar();
	}

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public void guardar() {
		bo.guardar(usr);
		mensaje = "Informacion Guardada!";
	}

	public void editar(int id) {
		usr = bo.consultar(id);
	}

}
