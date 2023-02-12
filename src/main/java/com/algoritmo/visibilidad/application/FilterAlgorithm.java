package com.algoritmo.visibilidad.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;

public class FilterAlgorithm {

	public ArrayList<Product> filter(List<Product> product, List<Size> size, List<Stock> stock) {
		ArrayList<Product> productFilter = null;

		return productFilter;
	}

	
	
	public ArrayList<Product> filterSpecial(ArrayList<Product> product, ArrayList<Size> size, ArrayList<Stock> stock) {
		ArrayList<Product> productFilter = new ArrayList<Product>();
		for (Product p : product) {
			int isSpecial = 0;
			int isNoSpecial=0;
			for (Size si : size) {
				if (si.getProductId() == p.getId()) {
					for (Stock s : stock) {
						if (s.getSizeid() == si.getId()) {
							System.out.println("ID " + p.getId() + " Especial " + si.isSpecial() +" Backsoon "+si.isBackSoon() + " cantidad "+ s.getQuantity());
							if ((s.getQuantity() > 0 || si.isBackSoon())&& si.isSpecial()) isSpecial++;
							if ((s.getQuantity() > 0 || si.isBackSoon())&& !si.isSpecial())isNoSpecial++;
						}
					}
				}
			}
			if ((isSpecial>0 && isNoSpecial>0) || isNoSpecial>0) {
				System.out.println("MOSTRAR PRODUCTO2 " + p.toString());
				productFilter.add(p);
			}
		}
		Collections.sort(productFilter);
		return productFilter;
	}
	
}
