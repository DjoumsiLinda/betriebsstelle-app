package main.java.tech.getarrays.betriebsstelleapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import main.java.tech.getarrays.betriebsstelleapi.proxy.api.BetriebsstelleApiWebservice;
import main.java.tech.getarrays.betriebsstelleapi.proxy.beans.Betriebsstelle;

@SpringBootTest
class BetriebsstelleAppApplicationTests {
	
	@Autowired
	private BetriebsstelleApiWebservice apiWebservice;

	@Test
	void notSuccefullTest() {
		ResponseEntity<Betriebsstelle> erg = apiWebservice.anckelmannsplatz("test");
		
		assertThat(erg.getStatusCode().toString()).isEqualTo("404 NOT_FOUND");
		assertThat(erg.getBody()).isNull();
	}
	
	@Test
	void succeffulTest() {
		ResponseEntity<Betriebsstelle> erg = apiWebservice.anckelmannsplatz("aamp");
		
		assertThat(erg.getStatusCode().toString()).isEqualTo("200 OK");
		assertThat(erg.getBody().getName()).isNotNull();
	}

}
