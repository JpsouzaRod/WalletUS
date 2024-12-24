package com.example.WalletUS.Service;

import org.springframework.stereotype.Service;

@Service
public class ConversorMoeda {

    private final float VALOR_DOLAR =  6.08f;

    public float ConverterRealParaDolar(float real)
    {
        return real / VALOR_DOLAR;
    }

    public float ConverterDolarparaReal(float dolar)
    {
        return dolar * VALOR_DOLAR;
    }


}
