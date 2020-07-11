package com.project.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.cursomc.domain.Categoria;
import com.project.cursomc.domain.Cidade;
import com.project.cursomc.domain.Cliente;
import com.project.cursomc.domain.Endereco;
import com.project.cursomc.domain.Estado;
import com.project.cursomc.domain.Produto;
import com.project.cursomc.domain.enums.TipoCliente;
import com.project.cursomc.repositores.CategoriaRepository;
import com.project.cursomc.repositores.CidadeRepository;
import com.project.cursomc.repositores.ClienteRepository;
import com.project.cursomc.repositores.EnderecoRepository;
import com.project.cursomc.repositores.EstadoRepository;
import com.project.cursomc.repositores.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador",2000.000);
		Produto p2 = new Produto(null, "Impresora",800.0);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São paulo");
		
        Cidade c1 = new Cidade(null,"Unberlandia",est1);
        Cidade c2 = new Cidade(null,"São paulo",est2);
        Cidade c3 = new Cidade(null,"Campinas",est2);
		
        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));
        
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        
        Cliente cli1 = new Cliente(null,"Maria silva", "maria@gmail.com","363789123377", TipoCliente.PESSOAFISICA);
      
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
        
        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida matos", "105", "Sala 800", "Centre", "38777012", cli1, c2);
        
        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        
        
        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    
	}	
}














