package com.techcamp.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techcamp.app.helper.CSVService;

@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "*")
public class CSVController {
	
	@Autowired
	private CSVService csvService;
	
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Numero personal", "Nombre", "Apellido",
			"Salario","Email","Estado","Cargo","Compañía" };
	
	public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	
	@PostMapping("/csv")
    public ResponseEntity<?> uploadCSV(@RequestParam("file") MultipartFile file) throws IOException {
		
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        
        if(!hasCSVFormat(file)) {
        	return null;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int i=0;
            while ((line = reader.readLine()) != null) {
            	
            	if(i>0) {
	            	
	                String[] data = line.split(",");
	                
	                if (data.length == 8 ) {
	                	
	                	if(!csvService.uploadCsv(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7])) {
	                		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	                	}
	                }
                
            	}
                
                i++;
            }
        }catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
}
