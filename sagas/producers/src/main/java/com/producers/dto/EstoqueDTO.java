package com.producers.dto;

import java.io.Serializable;

//implementa serializable para permitir que a classe seja transformada em bytes para transfer. de infos

public class EstoqueDTO implements Serializable{
	public String codigoProduto;
	public int quantidade;

}
