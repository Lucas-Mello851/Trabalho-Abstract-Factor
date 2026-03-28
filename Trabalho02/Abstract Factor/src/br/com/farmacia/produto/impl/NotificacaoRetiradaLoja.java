package br.com.farmacia.produto.impl;

import br.com.farmacia.produto.NotificacaoCliente;

public class NotificacaoRetiradaLoja implements NotificacaoCliente {

    @Override
    public void enviarNotificacao(String cliente, String pedido) {
        System.out.println("Notificação para " + cliente + ":");
        System.out.println("Seu pedido " + pedido + " já está disponível para retirada na loja.");
    }
}