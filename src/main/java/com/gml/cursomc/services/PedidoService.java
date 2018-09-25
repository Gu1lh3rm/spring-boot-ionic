package com.gml.cursomc.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.gml.cursomc.domain.ItemPedido;
import com.gml.cursomc.domain.PagamentoComBoleto;
import com.gml.cursomc.domain.Pedido;
import com.gml.cursomc.domain.enums.EstadoPagamento;
import com.gml.cursomc.repositories.ItemPedidoRepository;
import com.gml.cursomc.repositories.PagamentoRepository;
import com.gml.cursomc.services.exceptions.ObjectNotFoundException;
import com.gml.cursomc.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        /*Busca de cliente para a impressão do toString de Pedido*/
        obj.setCliente(clienteService.findById(obj.getCliente().getId()));

        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);

        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }

        obj = pedidoRepository.save(obj);
        pagamentoRepository.save(obj.getPagamento());

        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            /*Busca de Produto para a impressão do toString de ItemPedido*/
            ip.setProduto(produtoService.findById(ip.getProduto().getId()));

            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }

        itemPedidoRepository.saveAll(obj.getItens());
        emailService.sendOrderConfirmationEmail(obj);
        return obj;

    }
}
