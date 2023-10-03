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
public class ProdutoJsonController {

    @Autowired
    private AppJsonProduto appJsonProduto;

    @GetMapping("/")
    public List<Produto> getAll() {
        return appJsonProduto.getAll();
    }

    @PostMapping("/")
    public Produto createProduto(@RequestBody Produto produto) {
        return appJsonProduto.create(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        appJsonProduto.delete(id);

    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable int id){
        return null;
    }
}