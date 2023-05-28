package com.reto03.grupog6.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto03.grupog6.CrudRepository.ClientCrudRepository;
import com.reto03.grupog6.Entities.Client;

@Repository
public class ClientRepository  {
    @Autowired 

    private ClientCrudRepository clientRepository;
     public Client addClient(Client client){
      if (client.getIdClient() == null || client.getIdClient() == 0)
      return clientRepository.save(client);
  else
      return client;
     }

public List<Client> getall(){
    return (List<Client>) clientRepository.findAll();
  }
  private Client existClient(Integer id) {
    Optional<Client> objClient = clientRepository.findById(id);
    Client objClientRespuesta;

    if (objClient.isEmpty() == true)
        objClientRespuesta = null;
    else
        objClientRespuesta = objClient.get();
    
    return objClientRespuesta;

}

public Client updClient(Client client) {
    Client objClient;

    objClient = existClient(client.getIdClient());
    if (objClient == null)
        return client;
    else {
        if (client.getName() != null)
            objClient.setName(client.getName());

        if (client.getEmail() != null)
            objClient.setEmail(client.getEmail());

        if (client.getPassword() != null)
            objClient.setPassword(client.getPassword());

        if (client.getAge() != null)
            objClient.setAge(client.getAge());

        return clientRepository.save(objClient);

    }
}

public void delClient(Integer id) {
    Client objClient;

    objClient = existClient(id);
    if (objClient != null)
        clientRepository.deleteById(id);
}

public Client getClient(Integer id) {
    Client objClient;

    objClient = existClient(id);
    if (objClient != null)
        return objClient;
    else
        return null;
    
}

public Integer CountReservations(String status){
     return clientRepository.CountReservations(status);
}
}
