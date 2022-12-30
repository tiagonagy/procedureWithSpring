package com.invoke.proc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoke.proc.entity.Produtos;
import com.invoke.proc.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produtos consultaProdutoPorProc(Integer codigo) {
		return repository.consulta(codigo);
	}

	public List<Produtos> consultaTodosPorProc() {
		return repository.consultaTodos();
	}

	public List<Produtos> consultaTodosPorAnotacaoQuery() {
		return repository.consultaTodosPorAnotacaoQuery();
	}
	
	public Produtos consultaPorAnotacaoQuery(Integer codigo) {
		return repository.consultaPorAnotacaoQuery(codigo);
	}

}
