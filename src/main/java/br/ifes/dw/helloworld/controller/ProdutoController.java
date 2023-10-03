package br.ifes.dw.helloworld.controller;
import br.ifes.dw.helloworld.exception.NotFound;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.application.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private AppProduto appProduto;

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