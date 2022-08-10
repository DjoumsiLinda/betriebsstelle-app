package main.java.tech.getarrays.betriebsstelleapp.proxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import main.java.tech.getarrays.betriebsstelleapi.proxy.api.BetriebsstelleApiWebservice;
import main.java.tech.getarrays.betriebsstelleapi.proxy.beans.Betriebsstelle;
import main.java.tech.getarrays.betriebsstelleapp.proxy.service.BetriebsstelleService;

@RestController
public class BetriebsstelleController implements BetriebsstelleApiWebservice
{
	private BetriebsstelleService betriebsstelleService;
	
	public BetriebsstelleController(BetriebsstelleService betriebsstelleService) {
		this.betriebsstelleService = betriebsstelleService;
	}
	
	@Override
	public ResponseEntity<Betriebsstelle> anckelmannsplatz(String bst) {
		Betriebsstelle erg = betriebsstelleService.stelle(bst);
		if(erg==null)
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(erg, HttpStatus.OK);
	}
}
