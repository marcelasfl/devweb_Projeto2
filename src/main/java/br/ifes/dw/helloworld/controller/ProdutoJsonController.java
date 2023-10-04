package br.ifes.dw.helloworld.controller;
import br.ifes.dw.helloworld.exception.NotFound;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.application.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class ProdutoJsonController {
    @Autowired

    AppProdutoJson appProduto;

    @GetMapping("/")
    public ResponseEntity<List<Produto>> getAll() throws IOException {
        List<Produto> produtos = appProduto.findAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) throws IOException {
        try {
            Produto novoProduto = appProduto.save(produto);
            return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable int id) throws IOException {
        try {
            appProduto.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return null;
        }
    }

    @PutMapping("/")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) throws IOException {
        try {
            Produto updatedProduto = appProduto.update(produto);
            return new ResponseEntity<>(updatedProduto, HttpStatus.OK);
        } catch (IdNotFoundException e) {
            return new ResponseEntity<>(null);
        }
    }
}

}
