package com.example.WalletUS.Service;

import com.example.WalletUS.Model.Enum.EnumMoeda;
import com.example.WalletUS.Model.Transacao;
import com.example.WalletUS.Repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Transactional
    public void RegistrarTransacao(Long cliente, EnumMoeda moeda, float valor){
        Transacao transacao = new Transacao(cliente, moeda, valor);
        transacaoRepository.save(transacao);
    }
}
