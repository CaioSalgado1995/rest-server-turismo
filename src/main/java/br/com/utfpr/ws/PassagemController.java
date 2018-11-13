package br.com.utfpr.ws;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passagem")
public class PassagemController {

	
	private List<Passagem> passagens = new ArrayList<Passagem>();
	
	public PassagemController() {
		inicializaPassagens();
	}
	
	public void inicializaPassagens() {
		Passagem p1 = new Passagem();
		Passagem p2 = new Passagem();
		Passagem p3 = new Passagem();
		Passagem p4 = new Passagem();
		
		p1.setDataIda("21/08/2018");
		p1.setDataVolta("22/08/2018");
		p1.setOrigem("Curitiba");
		p1.setDestino("Rio de Janeiro");
		p1.setNumeroPessoas(2);
		p1.setTipo(1);
		
		p2.setDataIda("21/08/2018");
		p2.setDataVolta("22/08/2018");
		p2.setOrigem("Curitiba");
		p2.setDestino("Florianopolis");
		p2.setNumeroPessoas(2);
		p2.setTipo(1);
		
		p3.setDataIda("21/08/2018");
		p3.setDataVolta("22/08/2018");
		p3.setOrigem("Curitiba");
		p3.setDestino("Tupa");
		p3.setNumeroPessoas(2);
		p3.setTipo(1);
		
		p4.setDataIda("21/08/2018");
		p4.setDataVolta("22/08/2018");
		p4.setOrigem("Curitiba");
		p4.setDestino("São Paulo");
		p4.setNumeroPessoas(1);
		p4.setTipo(1);
		
		
		passagens.add(p1);
		passagens.add(p2);
		passagens.add(p3);
		passagens.add(p4);
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<String> consultarPassagem(@RequestBody Passagem passagem) {
		
		boolean encontrouPassagem = false;
		
		for (Passagem p : passagens) {
			if(p.equals(passagem)) {
				encontrouPassagem = true;
				break;
			}
		}
		
		if(encontrouPassagem) {
			return new ResponseEntity<String>("Passagem existente", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Passagem inexistente", HttpStatus.OK);
	}
	
	@PostMapping("/comprar")
	public ResponseEntity<String> comprarPassagem(@RequestBody Passagem passagem) {
		boolean encontrouPassagem = false;
		Passagem comprada = null;
		
		for (Passagem p : passagens) {
			if(p.equals(passagem)) {
				encontrouPassagem = true;
				comprada = p;
				break;
			}
		}
		
		if(encontrouPassagem) {
			passagens.remove(comprada);
			return new ResponseEntity<String>("Passagem adquirida com sucesso", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Passagem indisponível", HttpStatus.OK);
	}
	
}
