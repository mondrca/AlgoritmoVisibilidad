package com.algoritmo.visibilidad.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Size {
	private int id;
	private int productId;
	private boolean backSoon;
	private boolean special;
	
}
