package br.com.farmacia.factory.impl;

import br.com.farmacia.factory.AtendimentoFactory;
import br.com.farmacia.produto.EtiquetaEntrega;
import br.com.farmacia.produto.NotificacaoCliente;
import br.com.farmacia.produto.impl.EtiquetaCorreios;
import br.com.farmacia.produto.impl.NotificacaoCorreios;

public class CorreiosFactory implements AtendimentoFactory {

    @Override
    public EtiquetaEntrega criarEtiqueta() {
        return new EtiquetaCorreios();
    }

    @Override
    public NotificacaoCliente criarNotificacao() {
        return new NotificacaoCorreios();
    }
}