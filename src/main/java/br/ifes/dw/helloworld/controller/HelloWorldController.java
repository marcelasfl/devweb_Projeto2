package br.ifes.dw.helloworld.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController{


  @GetMapping("/")
  public String helloWorld(){
    return "Oiiiiiiiiiiiiiiiiii";
  }

  @GetMapping("/xyz")
  public String helloWorld2 (@RequestParam String nome){
    return "Meu nome é: " + nome;
  }
  
}

//cria um controlador para cada recurso
