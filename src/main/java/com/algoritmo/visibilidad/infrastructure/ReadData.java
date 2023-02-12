package com.algoritmo.visibilidad.infrastructure;

import java.io.IOException;
import java.util.ArrayList;

import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;

public interface ReadData {
	public ArrayList<Product> readProduct(String file);
	public ArrayList<Size> readSize(String file);
	public ArrayList<Stock> readStock(String file);
	
}
