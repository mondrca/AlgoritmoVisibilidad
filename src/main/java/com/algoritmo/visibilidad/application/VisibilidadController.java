package com.algoritmo.visibilidad.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;
import com.algoritmo.visibilidad.infrastructure.ReadCSV;

@RestController
public class VisibilidadController {
ReadCSV csv=new ReadCSV();
FilterAlgorithm algorithm=new FilterAlgorithm();
String result="";

@GetMapping("/")
	public String initial() throws IOException {
		ArrayList<Product> productFilter=new ArrayList<Product>();
		
		ArrayList<Product> products=csv.readProduct("product.csv");
		ArrayList<Size> sizes=csv.readSize("size.csv");
		ArrayList<Stock> stocks= csv.readStock("stock.csv");
		productFilter=algorithm.filterSpecial(products, sizes, stocks);
		
		return productFilter.stream().map(Objects::toString).collect(Collectors.joining(", "));
	}
	
}
