package com.producers.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
public class ContaDTO implements Serializable{
	public int id;
	public int clienteId;
	public int gerenteId;
	public String numero;
	public double saldo;
	public double limite;
	public Date dataCriacao;
	public List<MovimentacaoDTO> movimentacoes;
}
