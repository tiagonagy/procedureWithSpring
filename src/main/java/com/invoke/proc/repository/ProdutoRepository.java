package com.invoke.proc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invoke.proc.entity.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {

	@Procedure
	Produtos consulta(Integer codigo);

	@Procedure
	List<Produtos> consultaTodos();

	@Query(value = "CALL consultaTodos();", nativeQuery = true)
	List<Produtos> consultaTodosPorAnotacaoQuery();

	@Query(value = "CALL consulta(:codigo);", nativeQuery = true)
	Produtos consultaPorAnotacaoQuery(@Param("codigo") Integer codigo);
}
