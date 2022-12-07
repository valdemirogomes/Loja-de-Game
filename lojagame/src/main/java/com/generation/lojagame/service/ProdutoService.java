package com.generation.lojagame.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.generation.lojagame.entity.Produto;
import com.generation.lojagame.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	public ResponseEntity<Produto> getById(Long id) {
		Produto produto = repository.getById(id);

		if (produto == null) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(produto);
		}

	}
	
	public ResponseEntity<List<Produto>> getByTitulo(String titulo){
		List<Produto> produto = repository.getByTitulo(titulo);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();

		}else {
		return ResponseEntity.ok(produto);
		
	}}
}