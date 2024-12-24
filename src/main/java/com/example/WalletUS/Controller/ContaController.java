package com.example.WalletUS.Controller;

import com.example.WalletUS.Repository.ContaRepository;
import com.example.WalletUS.Model.Conta;
import com.example.WalletUS.Service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    private ContaRepository repository;
    @Autowired
    private ContaService service;

    @PostMapping("cadastro")
    public ResponseEntity<Conta> cadastrarConta (@RequestBody Conta conta)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(conta));
    }

    @PostMapping("Consulta")
    public ResponseEntity<Conta> consultarConta (@RequestBody Conta conta)
    {
        return ResponseEntity.ok(service.consultarConta(conta.getNumeroConta()));
    }

    @DeleteMapping("excluir")
    public ResponseEntity excluirConta (@RequestBody Conta conta)
    {
        service.apagarConta(conta.getNumeroConta());
        return ResponseEntity.ok().build();
    }

}
