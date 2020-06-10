package com.algaworks.algamoneyapi.resource;

import com.algaworks.algamoneyapi.events.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import com.algaworks.algamoneyapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(pessoas);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa pss = pessoaRepository.save(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pss.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pss);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional categoria = pessoaRepository.findById(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo){
        pessoaRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa){
        Pessoa pss = pessoaService.atualizar(codigo, pessoa);
        return  ResponseEntity.ok(pss);
    }
    
    @PutMapping("/{codigo}/ativo")
    public ResponseEntity<Pessoa> atualizarPropriedadeAtivo(@PathVariable Long codigo, @Valid @RequestBody Boolean ativo){
        Pessoa pss = pessoaService.atualizarPropriedadeAtivo(codigo, ativo);
        return  ResponseEntity.ok(pss);
    }
    
}
