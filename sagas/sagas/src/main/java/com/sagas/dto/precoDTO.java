package com.sagas.dto;

import java.io.Serializable;

//implementa serializable para permitir que a classe seja transformada em bytes para transfer. de infos

public class precoDTO implements Serializable{
	public String codigoProduto;
	public double preco;

}
