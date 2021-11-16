package br.org.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	//Consulta pelo preço menor
	public List<Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	
	//Consulta pelo preço menor
	public List<Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
	
	//Consulta por nome ou laboratório
	public List<Produto> findByNomeOrLaboratorio(String nome, String laboratorio);
	
	//Consulta por nome e laboratório
	public List<Produto> findByNomeAndLaboratorio(String nome, String laboratorio);
	
	//Consulta por preço entre dois valores (Between)
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <Produto> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);

}
