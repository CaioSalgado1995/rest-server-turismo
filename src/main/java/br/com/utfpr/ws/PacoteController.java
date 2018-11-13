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
@RequestMapping("/pacote")
public class PacoteController {
	
	private List<Pacote> pacotes = new ArrayList<Pacote>();
	
	public PacoteController() {
		inicializaPacotes();
	}
	
	public void inicializaPacotes() {
		Passagem p1 = new Passagem();
		Passagem p2 = new Passagem();
		Passagem p3 = new Passagem();
		
		
		Hospedagem h1 = new Hospedagem();
		Hospedagem h2 = new Hospedagem();
		Hospedagem h3 = new Hospedagem();
		
		Pacote pc1 = new Pacote();
		Pacote pc2 = new Pacote();
		Pacote pc3 = new Pacote();
		
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
		
		h1.setDataEntrada("21/08/2018");
		h1.setDataSaida("22/08/2018");
		h1.setOrigem("Curitiba");
		h1.setDestino("Rio de Janeiro");
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
		
		pc1.setPassagem(p1);
		pc1.setHospedagem(h1);
		
		pc2.setPassagem(p2);
		pc2.setHospedagem(h2);
		
		pc3.setPassagem(p3);
		pc3.setHospedagem(h3);
		
		pacotes.add(pc1);
		pacotes.add(pc2);
		pacotes.add(pc3);

	}
	
	@PostMapping("/consultar")
	public ResponseEntity<String> consultarPacote(@RequestBody Pacote pacote) {
		
		boolean encontrouPacote = false;
		
		for (Pacote p : pacotes) {
			if(p.equals(pacote)) {
				encontrouPacote = true;
				break;
			}
		}
		
		if(encontrouPacote) {
			return new ResponseEntity<String>("Pacote existente", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Pacote inexistente", HttpStatus.OK);
	}
	
	@PostMapping("/comprar")
	public ResponseEntity<String> comprarPacote(@RequestBody Pacote pacote) {
		boolean encontrouPacote = false;
		Pacote comprado = null;
		
		for (Pacote p : pacotes) {
			if(p.equals(pacote)) {
				encontrouPacote = true;
				comprado = p;
				break;
			}
		}
		
		if(encontrouPacote) {
			pacotes.remove(comprado);
			return new ResponseEntity<String>("Pacote adquirido com sucesso", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Pacote indisponível", HttpStatus.OK);
	}

}
