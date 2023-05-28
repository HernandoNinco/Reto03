package com.reto03.grupog6.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto03.grupog6.Entities.Client;
import com.reto03.grupog6.Services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all") 
    public List<Client> getall(){
        return clientService.getAll();
    }
    @GetMapping("/save")
      public Client addClient(Client client){
        return clientService.addClient(client);
        
      }
      @PutMapping("/update")
    public Client updClient(@RequestBody Client client) {
        return clientService.updClient(client);
    }

    @DeleteMapping("/{id}")
    public void delClient(@PathVariable Integer id) {
         clientService.delClient(id);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Integer id) {
        return clientService.getClient(id);
    }

}
