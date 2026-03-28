package br.com.farmacia.service;

import br.com.farmacia.factory.AtendimentoFactory;
import br.com.farmacia.produto.EtiquetaEntrega;
import br.com.farmacia.produto.NotificacaoCliente;

public class PedidoService {

    private EtiquetaEntrega etiqueta;
    private NotificacaoCliente notificacao;

    public PedidoService(AtendimentoFactory factory) {
        this.etiqueta = factory.criarEtiqueta();
        this.notificacao = factory.criarNotificacao();
    }

    public void processarPedido(String cliente, String destino, String pedido) {
        etiqueta.gerarEtiqueta(cliente, destino);
        notificacao.enviarNotificacao(cliente, pedido);
        System.out.println("Pedido processado com sucesso.\n");
    }
}