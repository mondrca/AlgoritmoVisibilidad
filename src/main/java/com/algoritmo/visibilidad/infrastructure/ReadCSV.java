package com.algoritmo.visibilidad.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algoritmo.visibilidad.VisibilidadApplication;
import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class ReadCSV implements ReadData {
	
	private ColumnPositionMappingStrategy strat = null;
	private CsvToBean csv = null;

	@Override
	public ArrayList<Product> readProduct(String file) {
		ArrayList<Product> products = null;
		try {
			strat = new ColumnPositionMappingStrategy();
			csv = new CsvToBean();
			CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(file)));
			strat.setType(Product.class);
			String[] columns = new String[] { "id", "sequence" };
			strat.setColumnMapping(columns);
			products = (ArrayList<Product>) csv.parse(strat, reader);
			for (Product e : products) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return products;
	}

	@Override
	public ArrayList<Size> readSize(String file) {
		ArrayList<Size> sizes = null;
		try {
			strat = new ColumnPositionMappingStrategy();
			csv = new CsvToBean();
			CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(file)));
			strat.setType(Size.class);
			String[] columns = new String[] { "id", "productId", "backSoon", "special" };
			strat.setColumnMapping(columns);
			sizes = (ArrayList<Size>) csv.parse(strat, reader);
			for (Size e : sizes) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sizes;
	}

	@Override
	public ArrayList<Stock> readStock(String file) {
		ArrayList<Stock> stocks = null;
		try {
			strat = new ColumnPositionMappingStrategy();
			csv = new CsvToBean();
			CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(file)));
			strat.setType(Stock.class);
			String[] columns = new String[] { "sizeId", "quantity" };
			strat.setColumnMapping(columns);
			stocks = (ArrayList<Stock>) csv.parse(strat, reader);
			for (Stock e : stocks) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return stocks;
	}

}