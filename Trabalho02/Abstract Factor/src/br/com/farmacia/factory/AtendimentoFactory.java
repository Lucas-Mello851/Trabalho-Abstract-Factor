package br.com.farmacia.factory;

import br.com.farmacia.produto.EtiquetaEntrega;
import br.com.farmacia.produto.NotificacaoCliente;

public interface AtendimentoFactory {
    EtiquetaEntrega criarEtiqueta();
    NotificacaoCliente criarNotificacao();
}