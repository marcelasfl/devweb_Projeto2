package br.ifes.dw.helloworld.application;

import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import org.springframework.stereotype.*;

@Component
public class AppProduto{

  private final List<Produto> produtos = new ArrayList<Produto>();
  private int lastId = 0;
  
    public List<Produto> getAll(){
      return produtos;
  }

  public Produto getById(int id){
    for (Produto produto : produtos){
      if (produto.getId() == id){
      return produto;
      } 
    }
    return null;
    
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
