package com.example.restservice;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class RestserviceApplication {
    
    
    @Component
    public class Estado{
        
        private Long id;
        private String nome;
        
        Estado(){}
        
        public Long getId(){
            return this.id;
        }
        
        public void setId(Long id){
            this.id = id;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
    }
    
    @Component
    public class Cidade{
        
        private Long id;
        private String nome;
        private Estado estado;
        
        Cidade(){}
        
        public Long getId(){
            return this.id;
        }
        
        public void setId(Long id){
            this.id = id;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public Estado getEstado(){
            return this.estado;
        }
        
        public void setEstado(Estado estado){
            this.estado = estado;
        }
    }
    
    
    @Component
    public class CidadeDAO{
        
        private List<Cidade> listaCidades = new ArrayList<>();
        
        public boolean create (Cidade cidade){
            return false;
        } 
        
        public List<Cidade> listaCidades(){
            Estado e = new Estado();
            e.setId(new Long(1));
            e.setNome("São Paulo");
            
            Cidade c = new Cidade();
            c.setId(new Long(1));
            c.setNome("Garça");
            c.setEstado(e);
            listaCidades.add(c);
            
            return listaCidades;
        }
        
        public boolean delete(Cidade cidade){
            return false;
        }
        
        public boolean update(Cidade cidade){
            return false;
        }
        
    }
    
    @Controller
    public class RestController{
        
        private CidadeDAO cDAO;
        
        RestController(CidadeDAO cDAO){
            this.cDAO = cDAO;
        }
        
        @PostMapping("/cidade")
        public Cidade create (@RequestBody Cidade cidade){
            return cidade;
        }
        
        @GetMapping("/cidade")
        public List<Cidade> listaCidades(){
            return cDAO.listaCidades();
        }
        
        @PutMapping("/cidade")
        public Cidade update (@RequestBody Cidade cidade){
            return cidade;
        }
        
        @DeleteMapping("/cidade/{id}")
        public int delete(@PathVariable int id){
            return 200;
        }
        
    }

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
}