package test.java;

import br.com.farmacia.factory.impl.CorreiosFactory;
import br.com.farmacia.factory.impl.RetiradaLojaFactory;
import br.com.farmacia.produto.impl.EtiquetaCorreios;
import br.com.farmacia.produto.impl.EtiquetaRetiradaLoja;
import br.com.farmacia.produto.impl.NotificacaoCorreios;
import br.com.farmacia.produto.impl.NotificacaoRetiradaLoja;
import br.com.farmacia.service.PedidoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setup() {
        originalOut = System.out;
        System.setOut(new PrintStream(saida));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOut);
    }

    @Test
    void correiosFactoryCriaEtiquetaCorreios() {
        assertInstanceOf(EtiquetaCorreios.class, new CorreiosFactory().criarEtiqueta());
    }

    @Test
    void correiosFactoryCriaNotificacaoCorreios() {
        assertInstanceOf(NotificacaoCorreios.class, new CorreiosFactory().criarNotificacao());
    }

    @Test
    void retiradaFactoryCriaEtiquetaRetirada() {
        assertInstanceOf(EtiquetaRetiradaLoja.class, new RetiradaLojaFactory().criarEtiqueta());
    }

    @Test
    void retiradaFactoryCriaNotificacaoRetirada() {
        assertInstanceOf(NotificacaoRetiradaLoja.class, new RetiradaLojaFactory().criarNotificacao());
    }

    @Test
    void pedidoCorreiosGeraEtiquetaCorreta() {
        new PedidoService(new CorreiosFactory())
                .processarPedido("Lucas", "Rua A, 10", "PED-001");

        String resultado = saida.toString();
        assertTrue(resultado.contains("ETIQUETA CORREIOS"));
        assertTrue(resultado.contains("Lucas"));
        assertTrue(resultado.contains("Rua A, 10"));
        assertTrue(resultado.contains("PED-001"));
    }

    @Test
    void pedidoRetiradaGeraEtiquetaCorreta() {
        new PedidoService(new RetiradaLojaFactory())
                .processarPedido("Ana", "Loja Centro", "PED-002");

        String resultado = saida.toString();
        assertTrue(resultado.contains("RETIRADA NA LOJA"));
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("Loja Centro"));
        assertTrue(resultado.contains("PED-002"));
    }

    @Test
    void correiosNaoImprimeMensagemDeRetirada() {
        new PedidoService(new CorreiosFactory())
                .processarPedido("X", "Y", "Z");

        assertFalse(saida.toString().contains("RETIRADA NA LOJA"));
    }

    @Test
    void retiradaNaoImprimeMensagemDeCorreios() {
        new PedidoService(new RetiradaLojaFactory())
                .processarPedido("X", "Y", "Z");

        assertFalse(saida.toString().contains("ETIQUETA CORREIOS"));
    }
}