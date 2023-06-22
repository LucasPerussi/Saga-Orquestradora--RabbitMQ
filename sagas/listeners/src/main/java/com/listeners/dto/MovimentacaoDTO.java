package com.listeners.dto;

import java.io.Serializable;
import java.sql.Date;

//implementa serializable para permitir que a classe seja transformada em bytes para transfer. de infos

public class MovimentacaoDTO implements Serializable{
	public int id;
	public Date data;
	public TipoMovimentacao tipo;
	public int idOrigem;
	public int idDestino;
}
