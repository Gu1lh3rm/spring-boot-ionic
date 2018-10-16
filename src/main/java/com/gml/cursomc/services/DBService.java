package com.gml.cursomc.services;


import com.gml.cursomc.domain.*;
import com.gml.cursomc.domain.enums.EstadoPagamento;
import com.gml.cursomc.domain.enums.Perfil;
import com.gml.cursomc.domain.enums.TipoCliente;
import com.gml.cursomc.repositories.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired BucketService bucketService;

    @Value("${bucket.url}")
    private String urlBase;

    @Value("${bucket.url.token}")
    private String urlTokenType;

    public void instantiateTestDatabase() throws ParseException {
        Categoria cat1 = new Categoria(null, "Informática", null);
        Categoria cat2 = new Categoria(null, "Escritório", null);
        Categoria cat3 = new Categoria(null, "Cama mesa e banho", null);
        Categoria cat4 = new Categoria(null, "Eletrônicos", null);
        Categoria cat5 = new Categoria(null, "Jardinagem", null);
        Categoria cat6 = new Categoria(null, "Decoração", null);
        Categoria cat7 = new Categoria(null, "Perfumaria", null);

        Produto p1 = new Produto(null, "Computador", 2000.00, null, null);
        Produto p2 = new Produto(null, "Impressora", 800.00, null, null);
        Produto p3 = new Produto(null, "Mouse", 80.00, null, null);
        Produto p4 = new Produto(null, "Mesa de escritório", 300.00, null, null);
        Produto p5 = new Produto(null, "Toalha", 50.00, null, null);
        Produto p6 = new Produto(null, "Colcha", 200.00, null, null);
        Produto p7 = new Produto(null, "TV true color", 1200.00, null, null);
        Produto p8 = new Produto(null, "Roçadeira", 800.00, null, null);
        Produto p9 = new Produto(null, "Abajour", 100.00, null, null);
        Produto p10 = new Produto(null, "Pendente", 180.00, null, null);
        Produto p11 = new Produto(null, "Shampoo", 90.00, null, null);

        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        Estado est1 = new Estado(null,"Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null,"Campinas",est2);


        est1.getCidade().addAll(Arrays.asList(c1));
        est2.getCidade().addAll(Arrays.asList(c2,c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

        Cliente cli1 = new Cliente(null,"ADMINISTRADOR","guilhermemonteirolourenco1@gmail.com","22204455008", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("Guilherme123456789"), null);
        cli1.addPerfil(Perfil.ADMIN);
        cli1.getTelefones().addAll(Arrays.asList("45646546","131331"));
        Endereco e3 = new Endereco(null,"Jbairro","305", "Fundos","Jardim","123456", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e3));

        Cliente cli2 = new Cliente(null,"Guilherme 1","guilhermemonteirolourenco@gmail.com","40302207031", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("Guilherme123456789"), null);
        cli2.getTelefones().addAll(Arrays.asList("45646546","131331"));

        Endereco e1 = new Endereco(null,"Rua Flores","300", "Apto 303","Jardim","3232321312", cli1, c1);
        Endereco e2 = new Endereco(null,"Avenida Matos","105", "Sala 800","Centro","12541545125", cli1, c2);


        cli2.getEnderecos().addAll(Arrays.asList(e1, e2));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli2,e1);
        Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli2,e2);

        Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);

        ped1.setPagamento(pgto1);

        Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);

        ped2.setPagamento(pgto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

        pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);


        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

        getCatImgUrl();
        getUserImgUrl();
        getProdutoImgUrl();
    }


    public void getCatImgUrl(){
        List<Categoria> obj = categoriaService.findAll();

        obj.forEach(o -> {
            String tmp =  "/cat" + o.getId().toString() + urlTokenType + bucketService.getImgUrl("/cat" + o.getId().toString());
            o.setImgUrl(tmp);
            System.out.println(o.toString());

            categoriaRepository.save(o);
        });
    }

    public void getUserImgUrl(){
        List<Cliente> obj = clienteService.findAll();


        obj.forEach(o -> {
            String urlImg = bucketService.getImgUrl("/cp" + o.getId().toString());

            if(urlImg!=null){
                urlImg =  "/cp" + o.getId().toString() + urlTokenType + urlImg;
            }

            o.setImgUrl(urlImg);
            System.out.println(o.toString());

            clienteRepository.save(o);
        });
    }

    public void getProdutoImgUrl(){
        List<Produto> obj = produtoService.findAll();


        obj.forEach(o -> {
            String urlImg = bucketService.getImgUrl("/prod"+o.getId().toString());
            String urlSmal = bucketService.getImgUrl("/prod"+o.getId().toString() + "-small");

            if(urlImg!=null){
                urlImg =  "/prod" + o.getId().toString() + urlTokenType + urlImg;
            }

            if(urlSmal!=null){
                urlSmal =  "/prod" + o.getId().toString() + "-small" + urlTokenType + urlSmal;
            }

            o.setImgUrl(urlImg);
            o.setImgSmallUrl(urlSmal);
            System.out.println(o.toString());

            produtoRepository.save(o);
        });
    }

}
