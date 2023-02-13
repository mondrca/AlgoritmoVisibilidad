package com.algoritmo.visibilidad.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Size {
	private int id;
	private int productId;
	private boolean backSoon;
	private boolean special;
	
}
