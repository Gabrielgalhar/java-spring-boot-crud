package com.bn.demo.services;

import com.bn.demo.models.PessoaModel;
import com.bn.demo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> findAll(){
        return  pessoaRepository.findAll();
    }

    public PessoaModel  criarPessoa(PessoaModel pessoaModel){
        return  pessoaRepository.save(pessoaModel);
    }

    public Optional<PessoaModel> buscarid(Long id){
        return  pessoaRepository.findById(id);
    }


    public void deletarPessoa(Long id){
        pessoaRepository.deleteById(id);
    }

    public PessoaModel atualizarPessoa(Long id, PessoaModel pessoaAtualizada) {

        Optional<PessoaModel> pessoaExistente = pessoaRepository.findById(id);

        if (pessoaExistente.isPresent()) {
            PessoaModel pessoa = pessoaExistente.get();

            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setId(pessoaAtualizada.getId());

            return pessoaRepository.save(pessoa);
        } else {
            throw new RuntimeException("Pessoa não encontrada com id: " + id);
        }
    }

}
