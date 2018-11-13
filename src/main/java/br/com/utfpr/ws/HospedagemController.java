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
@RequestMapping("/hospedagem")
public class HospedagemController {

	private List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
	
	public HospedagemController() {
		inicializaHospedagens();
	}
	
	public void inicializaHospedagens() {
		
		Hospedagem h1 = new Hospedagem();
		Hospedagem h2 = new Hospedagem();
		Hospedagem h3 = new Hospedagem();
		
		h1.setDataEntrada("21/08/2018");
		h1.setDataSaida("02/09/2018");
		h1.setOrigem("Curitiba");
		h1.setDestino("Bonito");
		h1.setNumeroPessoas(2);
		h1.setNumeroQuartos(1);
		
		h2.setDataEntrada("21/08/2018");
		h2.setDataSaida("02/09/2018");
		h2.setOrigem("Curitiba");
		h2.setDestino("Rio de Janeiro");
		h2.setNumeroPessoas(4);
		h2.setNumeroQuartos(2);
		
		h3.setDataEntrada("21/08/2018");
		h3.setDataSaida("24/08/2018");
		h3.setOrigem("Curitiba");
		h3.setDestino("São Paulo");
		h3.setNumeroPessoas(2);
		h3.setNumeroQuartos(1);
		
		hospedagens.add(h1);
		hospedagens.add(h2);
		hospedagens.add(h3);
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<String> consultarHospedagem(@RequestBody Hospedagem hospedagem) {
		
		boolean encontrouHospedagem = false;
		
		for (Hospedagem h : hospedagens) {
			if(h.equals(hospedagem)) {
				encontrouHospedagem = true;
				break;
			}
		}
		
		if(encontrouHospedagem) {
			return new ResponseEntity<String>("Hospedagem existente", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Hospedagem inexistente", HttpStatus.OK);
	}
	
	@PostMapping("/comprar")
	public ResponseEntity<String> comprarHospedagem(@RequestBody Hospedagem hospedagem) {
		
		boolean encontrouHospedagem = false;
		Hospedagem comprada = null;
		
		for (Hospedagem h : hospedagens) {
			if(h.equals(hospedagem)) {
				encontrouHospedagem = true;
				comprada = h;
				break;
			}
		}
		
		if(encontrouHospedagem) {
			hospedagens.remove(comprada);
			return new ResponseEntity<String>("Hospedagem adquirida com sucesso", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Hospedagem inexistente", HttpStatus.OK);
	}
}
