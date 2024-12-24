package com.example.WalletUS.Controller;


import com.example.WalletUS.Model.Conta;
import com.example.WalletUS.Model.Transacao;
import com.example.WalletUS.Service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transacao")
public class OperacaoController {

    @Autowired
    private OperacaoService service;

    @PostMapping("/brl/deposito")
    public ResponseEntity<Conta> depositarReal(@RequestBody Transacao transacao)
    {
        return ResponseEntity.ok(
                service.depositarReal(transacao.getContaCliente(), transacao.getValorTransacionado())
        );
    }

    @PostMapping("/brl/saque")
    public ResponseEntity<Conta> sacarReal(@RequestBody Transacao transacao)
    {
        return ResponseEntity.ok(
                service.sacarReal(transacao.getContaCliente(), transacao.getValorTransacionado())
        );
    }

    @PostMapping("/usd/compra")
    public ResponseEntity<Conta> comprarDolar(@RequestBody Transacao transacao)
    {
        return ResponseEntity.ok(
                service.comprarDolar(transacao.getContaCliente(), transacao.getValorTransacionado())
        );
    }

    @PostMapping("/usd/venda")
    public ResponseEntity<Conta> venderDolar(@RequestBody Transacao transacao)
    {
        return ResponseEntity.ok(
                service.venderDolar(transacao.getContaCliente(), transacao.getValorTransacionado())
        );
    }

}
