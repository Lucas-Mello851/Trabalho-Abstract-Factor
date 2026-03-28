package br.com.farmacia.produto.impl;

import br.com.farmacia.produto.EtiquetaEntrega;

public class EtiquetaCorreios implements EtiquetaEntrega {

    @Override
    public void gerarEtiqueta(String cliente, String destino) {
        System.out.println("=== ETIQUETA CORREIOS ===");
        System.out.println("Cliente: " + cliente);
        System.out.println("Endereço: " + destino);
        System.out.println("Tipo de envio: Correios");
    }
}