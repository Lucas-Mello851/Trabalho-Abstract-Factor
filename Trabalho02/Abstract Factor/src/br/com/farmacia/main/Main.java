package br.com.farmacia.main;

import br.com.farmacia.factory.AtendimentoFactory;
import br.com.farmacia.factory.impl.CorreiosFactory;
import br.com.farmacia.factory.impl.*;
import br.com.farmacia.service.PedidoService;

public class Main {

    public static void main(String[] args) {

        AtendimentoFactory factoryCorreios = new CorreiosFactory();
        PedidoService pedidoCorreios = new PedidoService(factoryCorreios);
        pedidoCorreios.processarPedido(
                "Lucas Pereira",
                "Rua das Palmeiras, 120 - São Paulo",
                "PED-1001"
        );

        AtendimentoFactory factoryRetirada = new RetiradaLojaFactory();
        PedidoService pedidoRetirada = new PedidoService(factoryRetirada);
        pedidoRetirada.processarPedido(
                "Ana Souza",
                "Farmácia Central - Unidade Centro",
                "PED-1002"
        );
    }
}