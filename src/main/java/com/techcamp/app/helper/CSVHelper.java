package com.techcamp.app.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Numero personal", "Nombre", "Apellido",
			"Salario","Email","Estado","Cargo","Compañía" };
	
	public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }


}
