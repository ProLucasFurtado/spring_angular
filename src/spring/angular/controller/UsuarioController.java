package spring.angular.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import spring.angular.dao.DaoImplementacao;
import spring.angular.dao.DaoInterface;
import spring.angular.model.Usuario;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController extends DaoImplementacao<Usuario> implements DaoInterface<Usuario> {

	public UsuarioController(Class<Usuario> persistenceClass) {
		super(persistenceClass);
	}

	/**
	 * Salva ou atualiza o usuario do sistema
	 * 
	 * @param jsonUsuario
	 * @return ResponseEntity
	 * @throws Exception
	 */
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody String jsonUsuario) throws Exception {
		Usuario usuario = new Gson().fromJson(jsonUsuario, Usuario.class);
		super.salvarOuAtualizar(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);

	}

}
