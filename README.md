# Como mudar a porta do Spring
    * No arquivo application.properties adicione a linha server.port=${port:8081}
# Como inserir uma objeto em um Resource 
    *
     package com.gml.cursomc.resources;
     
     import com.gml.cursomc.domain.Categoria;
     import org.springframework.web.bind.annotation.GetMapping;
     import org.springframework.web.bind.annotation.RequestMapping;
     import org.springframework.web.bind.annotation.RestController;
     
     import java.util.ArrayList;
     import java.util.List;
     
     @RestController
     @RequestMapping(value="/categorias")
     public class CategoriaResource {
     
         @GetMapping
         public List<Categoria> listar(){
     
             Categoria cat1 = new Categoria(1,"Informática");
             Categoria cat2 = new Categoria(2,"Escritório");
     
             List<Categoria>  lista = new ArrayList<>();
             lista.add(cat1);
             lista.add(cat2);
     
             return lista;
         }
     }
 