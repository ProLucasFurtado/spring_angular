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
import spring.angular.model.Acesso;


@Controller
@RequestMapping(value = "/acesso")
public class AcessoController extends DaoImplementacao<Acesso> implements DaoInterface<Acesso> {

	public AcessoController(Class<Acesso> persistenceClass) {
		super(persistenceClass);
	}
	
	/**
	 * Salva ou atualiza o acesso
	 * @param jsonAcesso
	 * @return ResponseEntity
	 * @throws Exception
	 */
	 @RequestMapping(value="salvar", method= RequestMethod.POST)
	 @ResponseBody
	 public ResponseEntity<Acesso> salvar (@RequestBody String jsonAcesso) throws Exception {
		 Acesso acesso = new Gson().fromJson(jsonAcesso, Acesso.class);
		 super.salvarOuAtualizar(acesso);
		 return new ResponseEntity<Acesso>(acesso, HttpStatus.CREATED);
		 
	 }
}
