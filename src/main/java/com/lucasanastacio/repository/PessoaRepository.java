package com.lucasanastacio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasanastacio.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
