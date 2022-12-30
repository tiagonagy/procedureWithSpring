package com.invoke.proc.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoke.proc.entity.Produtos;
import com.invoke.proc.service.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@ApiOperation(value = "Consulta direto pelo JPA com 1 parametro")
	@GetMapping("/consultaPorProc/{codigo}")
	@Transactional
	public ResponseEntity<Produtos> consultaPorProc(@PathVariable Integer codigo) {
		Produtos produto = produtoService.consultaProdutoPorProc(codigo);

		if (produto != null) {
			return ResponseEntity.ok(produto);
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Consultar TODOS direto pelo JPA")
	@GetMapping("/consultaTodosPorProc")
	@Transactional
	public ResponseEntity<List<Produtos>> consultaTodosPorProc() {
		List<Produtos> produtos = produtoService.consultaTodosPorProc();

		if (!produtos.isEmpty()) {
			return ResponseEntity.ok(produtos);
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Consultar TODOS com anotação @Query + JPA")
	@GetMapping("/consultaTodosPorAnotacaoQuery")
	@Transactional
	public ResponseEntity<List<Produtos>> consultaTodosPorAnotacaoQuery() {
		List<Produtos> produtos = produtoService.consultaTodosPorAnotacaoQuery();

		if (!produtos.isEmpty()) {
			return ResponseEntity.ok(produtos);
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Consultar com anotação @Query + JPA com 1 parametro")
	@GetMapping("/consultaPorAnotacaoQuery/{codigo}")
	@Transactional
	public ResponseEntity<?> consultaPorAnotacaoQuery(@PathVariable Integer codigo) {
		Produtos produto;
		produto = produtoService.consultaPorAnotacaoQuery(codigo);
		if (produto != null)
			return ResponseEntity.ok(produto);

		return ResponseEntity.notFound().build();
	}
}