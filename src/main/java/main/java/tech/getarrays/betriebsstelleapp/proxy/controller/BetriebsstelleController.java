package main.java.tech.getarrays.betriebsstelleapp.proxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import main.java.tech.getarrays.betriebsstelleapi.proxy.api.BetriebsstelleApiWebservice;
import main.java.tech.getarrays.betriebsstelleapi.proxy.beans.Betriebsstelle;
import main.java.tech.getarrays.betriebsstelleapp.proxy.service.BetriebsstelleService;

@RestController
public class BetriebsstelleController implements BetriebsstelleApiWebservice
{
	@Autowired
	private BetriebsstelleService betriebsstelleService;
	
	@Override
	public ResponseEntity<Betriebsstelle> anckelmannsplatz(String bst) {
		Betriebsstelle erg = betriebsstelleService.anckelmannsplatz(bst);
		if(erg==null)
		{
			return new ResponseEntity<>(erg, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(erg, HttpStatus.OK);
	}
}
