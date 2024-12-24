package com.example.WalletUS.Model;

import com.example.WalletUS.Model.Enum.EnumMoeda;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contaCliente;
    private Date dataTransacao = new Date();

    @Enumerated (EnumType.STRING)
    private EnumMoeda moedaTransacao;
    private float valorTransacionado;

    public Transacao(Long conta_cliente, EnumMoeda moeda, float valor_transacionado){
        this.contaCliente = conta_cliente;
        this.moedaTransacao = moeda;
        this.valorTransacionado = valor_transacionado;
    }

    public Transacao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(Long contaCliente) {
        this.contaCliente = contaCliente;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public EnumMoeda getMoedaTransacao() {
        return moedaTransacao;
    }

    public void setMoedaTransacao(EnumMoeda moedaTransacao) {
        this.moedaTransacao = moedaTransacao;
    }

    public float getValorTransacionado() {
        return valorTransacionado;
    }

    public void setValorTransacionado(float valorTransacionado) {
        this.valorTransacionado = valorTransacionado;
    }




}
