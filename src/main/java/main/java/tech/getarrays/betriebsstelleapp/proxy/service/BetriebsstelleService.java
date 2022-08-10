package main.java.tech.getarrays.betriebsstelleapp.proxy.service;

import java.io.*;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import main.java.tech.getarrays.betriebsstelleapi.proxy.beans.Betriebsstelle;

@Service
@Transactional
public class BetriebsstelleService {

	public Betriebsstelle stelle(String bst)
	{
		  
		try {
				InputStream is = getClass().getResourceAsStream("/betriebsstelle.csv");
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(is));
	            CSVParser csvParser = new CSVParser (fileReader,  CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
	            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	            for (CSVRecord csvRecord : csvRecords) {
	            	if(csvRecord.get("Abkurzung").compareTo(bst)==0)
	            	{
	            		Betriebsstelle betriebsstelle = new Betriebsstelle(); 
	            		betriebsstelle.setName(csvRecord.get("Name"));
	            		betriebsstelle.setKurzname(csvRecord.get("Kurzname"));
	            		betriebsstelle.setTyp(csvRecord.get("Typ"));
	            		return betriebsstelle;
	            	}
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       return null;
	}
}
