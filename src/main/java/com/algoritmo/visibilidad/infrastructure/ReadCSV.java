package com.algoritmo.visibilidad.infrastructure;



import java.io.InputStreamReader;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;



public class ReadCSV implements ReadData {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadCSV.class);
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
			for (Product e : products) {				LOGGER.info(e.toString());;
			}
		} catch (Exception e) {			LOGGER.error(e.getMessage());
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
			for (Size e : sizes) {				LOGGER.info(e.toString());;
			}
		} catch (Exception e) {			LOGGER.error(e.getMessage());
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
			for (Stock e : stocks) {				LOGGER.info(e.toString());
			}
		} catch (Exception e) {			LOGGER.error(e.getMessage());
		}
		return stocks;
	}

}