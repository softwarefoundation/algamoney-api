package com.algaworks.algamoneyapi.service;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pss = pesquisarPessoaPeloCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pss, "codigo");
        return pessoaRepository.save(pss);
    }
    
    
    public Pessoa pesquisarPessoaPeloCodigo(Long codigo) { 
         Optional<Pessoa> pssOptional = pessoaRepository.findById(codigo);

        if (!pssOptional.isPresent()) {
            throw new EmptyResultDataAccessException("Não foi encontrado nenhum registro com código : " + codigo, 1);
        }
        return pssOptional.get();
    }

}
