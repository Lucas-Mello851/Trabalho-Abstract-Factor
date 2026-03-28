package br.com.farmacia.produto.impl;

import br.com.farmacia.produto.EtiquetaEntrega;

public class EtiquetaRetiradaLoja implements EtiquetaEntrega {

    @Override
    public void gerarEtiqueta(String cliente, String destino) {
        System.out.println("=== RETIRADA NA LOJA ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Loja: " + destino);
        System.out.println("Tipo de atendimento: Retirada presencial");
    }
}