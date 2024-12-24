package com.example.WalletUS.Service;

import com.example.WalletUS.Model.Conta;
import com.example.WalletUS.Model.Enum.EnumMoeda;
import com.example.WalletUS.Repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService{

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private ConversorMoeda conversorMoeda;


    public Conta depositarReal(Long numeroConta, float valorReal) {
        try{
            Conta conta = contaRepository.findById(numeroConta)
                    .orElseThrow(()-> new IllegalArgumentException("Conta não encontrada"));

            conta.creditarValorReal(valorReal);
            transacaoService.RegistrarTransacao(numeroConta, EnumMoeda.BRL, valorReal);

            return contaRepository.save(conta);

        } catch (Exception e) {
            throw new IllegalArgumentException ("Não foi possivel finalizar essa operação");
        }
    }

    public Conta sacarReal(Long numeroConta, float valorRealSacado) {
        try{
            Conta conta = contaRepository.findById(numeroConta)
                    .orElseThrow(()-> new IllegalArgumentException("Conta não encontrada"));

            if (conta.getSaldoMoedaReal() < valorRealSacado){
                throw new IllegalArgumentException("Saldo insuficiente para completar a transação");
            }

            conta.debitarValorReal(valorRealSacado);
            transacaoService.RegistrarTransacao(numeroConta, EnumMoeda.BRL, -valorRealSacado);

            return contaRepository.save(conta);

        } catch (Exception e) {
            throw new IllegalArgumentException ("Não foi possivel finalizar essa operação");
        }
    }

    public Conta comprarDolar(Long numeroConta, float valorDolar) {
        try{
            Conta conta = contaRepository.findById(numeroConta)
                    .orElseThrow(()-> new IllegalArgumentException("Conta não encontrada"));

            float valorRealDescontado = conversorMoeda.ConverterDolarparaReal(valorDolar);

            if (conta.getSaldoMoedaReal() < valorRealDescontado)
            {
                throw new IllegalArgumentException("Saldo insuficiente finalizar transação");
            }

            conta.debitarValorReal(valorRealDescontado);
            conta.creditarValorDolar(valorDolar);

            transacaoService.RegistrarTransacao(numeroConta, EnumMoeda.BRL, -valorRealDescontado);
            transacaoService.RegistrarTransacao(numeroConta, EnumMoeda.USD, valorDolar);

            return contaRepository.save(conta);

        } catch (Exception e) {
            throw new IllegalArgumentException ("Não foi possivel finalizar essa operação");
        }
    }

    public Conta venderDolar(Long numeroConta, float valorDolar) {
        try{
            Conta conta = contaRepository.findById(numeroConta)
                    .orElseThrow(()-> new IllegalArgumentException("Conta não encontrada"));

            float valorRealConvertido = conversorMoeda.ConverterDolarparaReal(valorDolar);

            conta.creditarValorReal(valorRealConvertido);
            conta.debitarValorDolar(valorDolar);

            transacaoService.RegistrarTransacao(numeroConta, EnumMoeda.BRL, valorRealConvertido);
            transacaoService.RegistrarTransacao(numeroConta, EnumMoeda.USD, -valorDolar);

            return contaRepository.save(conta);

        } catch (Exception e) {
            throw new IllegalArgumentException ("Não foi possivel finalizar essa operação");
        }
    }

}
