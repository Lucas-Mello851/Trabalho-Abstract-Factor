package br.com.farmacia.factory.impl;

import br.com.farmacia.factory.AtendimentoFactory;
import br.com.farmacia.produto.EtiquetaEntrega;
import br.com.farmacia.produto.NotificacaoCliente;
import br.com.farmacia.produto.impl.EtiquetaRetiradaLoja;
import br.com.farmacia.produto.impl.NotificacaoRetiradaLoja;

public class RetiradaLojaFactory implements AtendimentoFactory {

    @Override
    public EtiquetaEntrega criarEtiqueta() {
        return new EtiquetaRetiradaLoja();
    }

    @Override
    public NotificacaoCliente criarNotificacao() {
        return new NotificacaoRetiradaLoja();
    }
}