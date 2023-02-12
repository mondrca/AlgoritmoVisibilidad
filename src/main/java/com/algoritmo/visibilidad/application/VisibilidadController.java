package com.algoritmo.visibilidad.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;
import com.algoritmo.visibilidad.infrastructure.ReadCSV;

@RestController
public class VisibilidadController {
ReadCSV a=new ReadCSV();
FilterAlgorithm b=new FilterAlgorithm();

	@GetMapping("/")
	public String initial() throws IOException {
		ArrayList<Product> productFilter=null;
		
		ArrayList<Product> products=a.readProduct("product.csv");
		ArrayList<Size> sizes=a.readSize("size.csv");
		ArrayList<Stock> stocks= a.readStock("stock.csv");

		
		productFilter=b.filterSpecial(products, sizes, stocks);
		

		
		return productFilter.toString();
	}
	
}
