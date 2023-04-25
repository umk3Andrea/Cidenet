package com.clientes.endpoint;
import com.clientes.model.Cliente;
import com.clientes.model.GetClientesRequest;
import com.clientes.model.GetClientesResponse;
import com.clientes.services.ClientesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;


@Endpoint
public class ClientesEndpoint {
    @Autowired
    private ClientesServices serv;
    @PayloadRoot(namespace = "http://tecgurus.net/customer.xsd", localPart = "getClientesRequest")
    @ResponsePayload
    public GetClientesResponse ConsultaClientes(@RequestPayload GetClientesRequest request){
        GetClientesResponse response = new GetClientesResponse();
        Optional<Cliente> cliente = serv.findById((long) request.getId());
        System.out.println(request);
        response.setId(Math.toIntExact(cliente.get().getId()));
        response.setNombre(cliente.get().getNombre());
        response.setApellido(cliente.get().getApellido());
        response.setEmail(cliente.get().getEmail());
        response.setTelefono(cliente.get().getTelefono());
        System.out.println(response);
        return response;
    }
}
