package br.ifes.dw.helloworld.application;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import org.springframework.stereotype.*;

@Component
public class AppJsonProduto{
    Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
    public AppJsonProduto(){
        List<Review> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
        data.toScreen();
    }
    private final Produto produtos = gson.fromJson(IOUtils.toString(''), Produto.class);

    private int lastId = 0;

    public List<Produto> getAll(){
        return produtos;
    }

    public Produto create(Produto produto){
        lastId++;

        produto.setId(lastId);

        produtos.add(produto);
        return produto;

    }

    public void delete(int id){
        this.produtos.removeIf(produto -> produto.getId() == id);
    }
}

