package com.algoritmo.visibilidad.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Comparator;
@Getter
@Setter
@NoArgsConstructor
@ToString(includeFieldNames = false,onlyExplicitlyIncluded = true)

public class Product implements Comparable<Product> {
	@ToString.Include
	private int id;
	private int sequence;
	
	@Override
	public int compareTo(Product product) {
		int compareSecuence=((Product)product).getSequence();
        /* For Ascending order*/
        return this.sequence-compareSecuence;
	}
	

}
