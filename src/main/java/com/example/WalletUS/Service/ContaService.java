package com.example.WalletUS.Service;

import com.example.WalletUS.Model.Conta;
import com.example.WalletUS.Repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    private TransacaoService transacaoService;

    public Conta criarConta(Conta conta) {
        try{
            return contaRepository.save(conta);
        }catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel finalizar essa operação");
        }
    }

    public Conta consultarConta(Long numeroConta) {
        try{
            return contaRepository.findById(numeroConta)
                    .orElseThrow(()-> new IllegalArgumentException("Conta não encontrada"));
        }catch(Exception e){
            throw new IllegalArgumentException ("Não foi possivel finalizar essa operação");
        }
    }

    public void apagarConta(Long numeroConta) {
        try{
            contaRepository.deleteById(numeroConta);
        }catch(Exception e){
            throw new IllegalArgumentException ("Não foi possivel finalizar essa operação");
        }
    }


}
