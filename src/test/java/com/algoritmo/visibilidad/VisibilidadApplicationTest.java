package com.algoritmo.visibilidad;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.algoritmo.visibilidad.application.FilterAlgorithm;
import com.algoritmo.visibilidad.application.VisibilidadController;
import com.algoritmo.visibilidad.domain.Product;
import com.algoritmo.visibilidad.domain.Size;
import com.algoritmo.visibilidad.domain.Stock;

public class VisibilidadApplicationTest {

	ArrayList<Product> productFilter=new ArrayList<Product>();
	ArrayList<Product> productFilterOK=new ArrayList<Product>();
	ArrayList<Product> products=new ArrayList<Product>();
	ArrayList<Size> sizes=new ArrayList<Size>();
	ArrayList<Stock> stocks= new ArrayList<Stock>();
	Product p=new Product();
	Size s=new Size();
	Stock st=new Stock();
	FilterAlgorithm resultProducts=new FilterAlgorithm();
	
	
	
	  @Test
	  public void test_when_a_product_is_in_stock() throws Exception {
		  p=new Product(1,3);
		  products.add(p);
		  p=new Product(2,2);
		  products.add(p);
		  p=new Product(3,1);
		  products.add(p);
		  s=new Size(11,1,false,false);
		  sizes.add(s);
		  s=new Size(12,2,false,false);
		  sizes.add(s);
		  s=new Size(13,3,false,false);
		  sizes.add(s);
		  st=new Stock(11,0);
		  stocks.add(st);
		  st=new Stock(12,0);
		  stocks.add(st);
		  st=new Stock(13,1);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[Product(3)]");
		}
	  
	  @Test
	  public void test_when_all_product_is_in_stock() throws Exception {
		  p=new Product(1,3);
		  products.add(p);
		  p=new Product(2,2);
		  products.add(p);
		  p=new Product(3,1);
		  products.add(p);
		  s=new Size(11,1,false,false);
		  sizes.add(s);
		  s=new Size(12,2,false,false);
		  sizes.add(s);
		  s=new Size(13,3,false,false);
		  sizes.add(s);
		  st=new Stock(11,1);
		  stocks.add(st);
		  st=new Stock(12,1);
		  stocks.add(st);
		  st=new Stock(13,1);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[Product(3), Product(2), Product(1)]");
		}
	  
	  @Test
	  public void test_when_all_product_is_in_BackSoon() throws Exception {
		  p=new Product(1,3);
		  products.add(p);
		  p=new Product(2,2);
		  products.add(p);
		  p=new Product(3,1);
		  products.add(p);
		  s=new Size(11,1,true,false);
		  sizes.add(s);
		  s=new Size(12,2,true,false);
		  sizes.add(s);
		  s=new Size(13,3,true,false);
		  sizes.add(s);
		  st=new Stock(11,0);
		  stocks.add(st);
		  st=new Stock(12,1);
		  stocks.add(st);
		  st=new Stock(13,0);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[Product(3), Product(2), Product(1)]");
		}
	  
	  @Test
	  public void test_when_all_product_is_in_special_and_some_backsoon() throws Exception {
		  p=new Product(1,6);
		  products.add(p);
		  p=new Product(2,2);
		  products.add(p);
		  p=new Product(3,3);
		  products.add(p);
		  p=new Product(4,1);
		  products.add(p);
		  s=new Size(11,1,true,true);
		  sizes.add(s);
		  s=new Size(12,2,true,true);
		  sizes.add(s);
		  s=new Size(13,3,true,true);
		  sizes.add(s);
		  s=new Size(14,1,false,true);
		  sizes.add(s);
		  s=new Size(15,2,false,true);
		  sizes.add(s);
		  s=new Size(16,3,false,true);
		  sizes.add(s);
		  s=new Size(17,1,false,true);
		  sizes.add(s);
		  s=new Size(18,2,false,true);
		  sizes.add(s);
		  s=new Size(19,3,false,true);
		  sizes.add(s);
		  st=new Stock(11,0);
		  stocks.add(st);
		  st=new Stock(12,0);
		  stocks.add(st);
		  st=new Stock(13,0);
		  stocks.add(st);
		  st=new Stock(12,1);
		  stocks.add(st);
		  st=new Stock(13,1);
		  stocks.add(st);
		  st=new Stock(14,1);
		  stocks.add(st);
		  st=new Stock(15,1);
		  stocks.add(st);
		  st=new Stock(16,1);
		  stocks.add(st);
		  st=new Stock(17,1);
		  stocks.add(st);
		  st=new Stock(18,1);
		  stocks.add(st);
		  st=new Stock(19,1);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[]");
		}
	  
	  @Test
	  public void test_when_some_product_is_in_special_and_some_backsoon() throws Exception {
		  p=new Product(1,6);
		  products.add(p);
		  p=new Product(2,2);
		  products.add(p);
		  p=new Product(3,3);
		  products.add(p);
		  p=new Product(4,1);
		  products.add(p);
		  s=new Size(11,1,true,false);
		  sizes.add(s);
		  s=new Size(12,2,true,false);
		  sizes.add(s);
		  s=new Size(13,3,true,false);
		  sizes.add(s);
		  s=new Size(14,1,false,true);
		  sizes.add(s);
		  s=new Size(15,2,false,true);
		  sizes.add(s);
		  s=new Size(16,3,false,true);
		  sizes.add(s);
		  s=new Size(17,1,false,true);
		  sizes.add(s);
		  s=new Size(18,2,false,true);
		  sizes.add(s);
		  s=new Size(19,3,false,true);
		  sizes.add(s);
		  st=new Stock(11,0);
		  stocks.add(st);
		  st=new Stock(12,0);
		  stocks.add(st);
		  st=new Stock(13,0);
		  stocks.add(st);
		  st=new Stock(12,1);
		  stocks.add(st);
		  st=new Stock(13,1);
		  stocks.add(st);
		  st=new Stock(14,1);
		  stocks.add(st);
		  st=new Stock(15,1);
		  stocks.add(st);
		  st=new Stock(16,1);
		  stocks.add(st);
		  st=new Stock(17,1);
		  stocks.add(st);
		  st=new Stock(18,1);
		  stocks.add(st);
		  st=new Stock(19,1);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[Product(2), Product(3), Product(1)]");
		}
	  
	  @Test
	  public void test_when_all_product_is_in_special() throws Exception {
		  p=new Product(1,3);
		  products.add(p);
		  p=new Product(2,2);
		  products.add(p);
		  p=new Product(3,1);
		  products.add(p);
		  s=new Size(11,1,false,true);
		  sizes.add(s);
		  s=new Size(12,2,true,true);
		  sizes.add(s);
		  s=new Size(13,3,true,true);
		  sizes.add(s);
		  st=new Stock(11,0);
		  stocks.add(st);
		  st=new Stock(12,1);
		  stocks.add(st);
		  st=new Stock(13,0);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[]");
		}
	  
	  @Test
	  public void test2_when_a_product_is_in_stock() throws Exception {
		  p=new Product(1,0);
		  products.add(p);
		  p=new Product(2,9);
		  products.add(p);
		  p=new Product(3,8);
		  products.add(p);
		  p=new Product(4,7);
		  products.add(p);
		  p=new Product(5,6);
		  products.add(p);
		  p=new Product(6,5);
		  products.add(p);
		  p=new Product(7,4);
		  products.add(p);
		  p=new Product(8,3);
		  products.add(p);
		  p=new Product(9,2);
		  products.add(p);
		  p=new Product(10,1);
		  products.add(p);
		  s=new Size(11,1,false,false);
		  sizes.add(s);
		  s=new Size(12,2,false,false);
		  sizes.add(s);
		  s=new Size(13,3,false,false);
		  sizes.add(s);
		  s=new Size(14,4,false,false);
		  sizes.add(s);
		  s=new Size(15,5,false,false);
		  sizes.add(s);
		  s=new Size(16,6,false,false);
		  sizes.add(s);
		  s=new Size(17,7,false,false);
		  sizes.add(s);
		  s=new Size(18,8,false,false);
		  sizes.add(s);
		  s=new Size(19,9,false,false);
		  sizes.add(s);
		  s=new Size(20,10,false,false);
		  sizes.add(s);
		  s=new Size(21,1,false,false);
		  sizes.add(s);
		  s=new Size(22,2,false,false);
		  sizes.add(s);
		  s=new Size(23,3,false,false);
		  sizes.add(s);
		  s=new Size(24,4,false,false);
		  sizes.add(s);
		  s=new Size(25,5,false,false);
		  sizes.add(s);
		  s=new Size(26,6,false,false);
		  sizes.add(s);
		  s=new Size(27,7,false,false);
		  sizes.add(s);
		  s=new Size(28,8,false,false);
		  sizes.add(s);
		  s=new Size(29,9,false,false);
		  sizes.add(s);
		  s=new Size(30,10,false,false);
		  sizes.add(s);
		  st=new Stock(11,0);
		  stocks.add(st);
		  st=new Stock(12,0);
		  stocks.add(st);
		  st=new Stock(13,1);
		  stocks.add(st);
		  st=new Stock(14,0);
		  stocks.add(st);
		  st=new Stock(15,0);
		  stocks.add(st);
		  st=new Stock(16,0);
		  stocks.add(st);
		  st=new Stock(17,0);
		  stocks.add(st);
		  st=new Stock(18,0);
		  stocks.add(st);
		  st=new Stock(19,0);
		  stocks.add(st);
		  st=new Stock(20,0);
		  stocks.add(st);
		  st=new Stock(21,0);
		  stocks.add(st);
		  st=new Stock(22,0);
		  stocks.add(st);
		  st=new Stock(23,0);
		  stocks.add(st);
		  st=new Stock(24,0);
		  stocks.add(st);
		  st=new Stock(25,0);
		  stocks.add(st);
		  st=new Stock(26,0);
		  stocks.add(st);
		  st=new Stock(27,0);
		  stocks.add(st);
		  st=new Stock(28,0);
		  stocks.add(st);
		  st=new Stock(29,0);
		  stocks.add(st);
		  st=new Stock(30,0);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[Product(3)]");
		}
	  
	  @Test
	  public void test2_when_all_product_is_in_stock() throws Exception {
		  p=new Product(1,0);
		  products.add(p);
		  p=new Product(2,9);
		  products.add(p);
		  p=new Product(3,8);
		  products.add(p);
		  p=new Product(4,7);
		  products.add(p);
		  p=new Product(5,6);
		  products.add(p);
		  p=new Product(6,5);
		  products.add(p);
		  p=new Product(7,4);
		  products.add(p);
		  p=new Product(8,3);
		  products.add(p);
		  p=new Product(9,2);
		  products.add(p);
		  p=new Product(10,1);
		  products.add(p);
		  s=new Size(11,1,false,false);
		  sizes.add(s);
		  s=new Size(12,2,false,false);
		  sizes.add(s);
		  s=new Size(13,3,false,false);
		  sizes.add(s);
		  s=new Size(14,4,false,false);
		  sizes.add(s);
		  s=new Size(15,5,false,false);
		  sizes.add(s);
		  s=new Size(16,6,false,false);
		  sizes.add(s);
		  s=new Size(17,7,false,false);
		  sizes.add(s);
		  s=new Size(18,8,false,false);
		  sizes.add(s);
		  s=new Size(19,9,false,false);
		  sizes.add(s);
		  s=new Size(20,10,false,false);
		  sizes.add(s);
		  s=new Size(21,1,false,false);
		  sizes.add(s);
		  s=new Size(22,2,false,false);
		  sizes.add(s);
		  s=new Size(23,3,false,false);
		  sizes.add(s);
		  s=new Size(24,4,false,false);
		  sizes.add(s);
		  s=new Size(25,5,false,false);
		  sizes.add(s);
		  s=new Size(26,6,false,false);
		  sizes.add(s);
		  s=new Size(27,7,false,false);
		  sizes.add(s);
		  s=new Size(28,8,false,false);
		  sizes.add(s);
		  s=new Size(29,9,false,false);
		  sizes.add(s);
		  s=new Size(30,10,false,false);
		  sizes.add(s);
		  st=new Stock(11,10);
		  stocks.add(st);
		  st=new Stock(12,10);
		  stocks.add(st);
		  st=new Stock(13,10);
		  stocks.add(st);
		  st=new Stock(14,10);
		  stocks.add(st);
		  st=new Stock(15,10);
		  stocks.add(st);
		  st=new Stock(16,10);
		  stocks.add(st);
		  st=new Stock(17,10);
		  stocks.add(st);
		  st=new Stock(18,10);
		  stocks.add(st);
		  st=new Stock(19,10);
		  stocks.add(st);
		  st=new Stock(20,10);
		  stocks.add(st);
		  st=new Stock(21,10);
		  stocks.add(st);
		  st=new Stock(22,10);
		  stocks.add(st);
		  st=new Stock(23,10);
		  stocks.add(st);
		  st=new Stock(24,10);
		  stocks.add(st);
		  st=new Stock(25,10);
		  stocks.add(st);
		  st=new Stock(26,10);
		  stocks.add(st);
		  st=new Stock(27,10);
		  stocks.add(st);
		  st=new Stock(28,10);
		  stocks.add(st);
		  st=new Stock(29,10);
		  stocks.add(st);
		  st=new Stock(30,10);
		  stocks.add(st);
		  productFilter=resultProducts.filterSpecial(products, sizes, stocks);
		  assertEquals(productFilter.toString(),"[Product(1), Product(10), Product(9), Product(8), Product(7), Product(6), Product(5), Product(4), Product(3), Product(2)]");
		}
	  
	  
}
