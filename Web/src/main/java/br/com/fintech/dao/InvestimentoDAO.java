package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Investimento;
import br.com.fintech.exception.DBException;

public interface InvestimentoDAO {
	void cadastrar(Investimento investimento) throws DBException;
	void atualizar(Investimento investimento) throws DBException;
	void remover(int cd) throws DBException;
	Investimento buscar(int cd);
	List<Investimento> listar();
}
