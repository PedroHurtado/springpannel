package com.example.demo.Application.Pizza;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.PizzaRepository;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;

@Configuration
public class Create {
 
    public record RequestPizza() implements Command<ResponsePizza>{

    }
    public record ResponsePizza(){}
    
    @RestController
    @RequestMapping("api/pizza")
    public class Controller{

        private final Pipeline pipeline;
        public Controller(final Pipeline pipeline){
            this.pipeline = pipeline;
        }
        @PostMapping
        public ResponsePizza create(@RequestBody RequestPizza request){
            return this.pipeline.send(request);            
        }
         
           
    }

    @Component
    public class CreateHandler implements Command.Handler<RequestPizza, ResponsePizza>{

        private final PizzaRepository repository;
        public  CreateHandler(final PizzaRepository repository){
            this.repository = repository;
        }
        @Override
        public ResponsePizza handle(RequestPizza request) {

           this.repository.add(null);
           return new ResponsePizza();
        }
    }
}
