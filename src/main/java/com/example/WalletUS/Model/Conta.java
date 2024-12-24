package com.example.WalletUS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroConta;
    private String nomeCliente;
    private float saldoMoedaReal = 0;
    private float saldoMoedaDolar = 0;

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldoMoedaReal() {
        return saldoMoedaReal;
    }

    public void setSaldoMoedaReal(float saldoMoedaReal) {
        this.saldoMoedaReal = saldoMoedaReal;
    }

    public float getSaldoMoedaDolar() {
        return saldoMoedaDolar;
    }

    public void setSaldoMoedaDolar(float saldoMoedaDolar) {
        this.saldoMoedaDolar = saldoMoedaDolar;
    }

    public void creditarValorReal(float valorReal)
    {
        this.saldoMoedaReal = this.saldoMoedaReal + valorReal;
    }
    public void debitarValorReal(float valorReal)
    {
        this.saldoMoedaReal = this.saldoMoedaReal - valorReal;
    }

    public void creditarValorDolar(float valorDolar)
    {
        this.saldoMoedaDolar = this.saldoMoedaDolar + valorDolar;
    }
    public void debitarValorDolar(float valorDolar)
    {
        this.saldoMoedaDolar = this.saldoMoedaDolar - valorDolar;
    }
}