package br.ifes.dw.helloworld.controller;
import br.ifes.dw.helloworld.exception.NotFound;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.application.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  private ProdutoService produtoService = null;
  @Autowired
  private AppProduto appProduto;


  @Autowired
  public ProdutoController(

          ProdutoService appProduto) {
    this.produtoService = produtoService;
  }

  @PostMapping
  public Produto criarProduto(@RequestBody Produto produto) {
    return produtoService.criarProduto(produto);
  }

  @GetMapping("/{id}")
  public Produto obterProdutoPorId(@PathVariable int id) {
    return produtoService.obterProdutoPorId(id);
  }

  @PutMapping("/{id}")
  public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
    return produtoService.atualizarProduto(id, produto);
  }

  @DeleteMapping("/{id}")
  public void deletarProduto(@PathVariable Long id) {
    produtoService.deletarProduto(id);
  }

  @GetMapping("/")
  public List<Produto> getAll() {
    return appProduto.getAll();
  }

  @PostMapping("/")
  public Produto createProduto(@RequestBody Produto produto) {
    return appProduto.create(produto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    appProduto.delete(id);

  }

  @GetMapping("/{id}")
  public Produto getById(@PathVariable int id){
    return null;
    }
  }
