package com.bn.demo.repositories;

import com.bn.demo.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
