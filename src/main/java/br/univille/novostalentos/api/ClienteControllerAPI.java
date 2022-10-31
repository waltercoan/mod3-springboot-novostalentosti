package br.univille.novostalentos.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.service.ClienteService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControllerAPI {
    @Autowired
    private ClienteService service;

    @ApiOperation(value = "Endpoint que retorna todos os dados dos clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        var listaClientes = service.getAll();
        return new ResponseEntity<>(listaClientes,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable long id){
        var umCliente = service.findById(id);
        if(umCliente.getId() == 0){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Cliente>(umCliente, HttpStatus.OK);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> findByNome(@PathVariable String nome){
        var listaClientes = service.findByNome(nome);
        return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> 
        findByNomeRequestParam(@RequestParam("nome") String nome){
        var listaClientes = service.findByNome(nome);
        return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        if(cliente.getId() == 0){
            var novoCliente = service.save(cliente);
            return new ResponseEntity<Cliente>(novoCliente, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable long id, @RequestBody Cliente clienteAlt){
        var clienteAntigo = service.findById(id);
        if(clienteAntigo.getId() == 0){
            return ResponseEntity.notFound().build();
        }
        clienteAntigo.setNome(clienteAlt.getNome());
        clienteAntigo.setEndereco(clienteAlt.getEndereco());
        clienteAntigo.setCidadeResidencia(clienteAlt.getCidadeResidencia());
        clienteAntigo.setDataNascimento(clienteAlt.getDataNascimento());
        clienteAntigo.setSexo(clienteAlt.getSexo());

        service.save(clienteAntigo);
        return new ResponseEntity<Cliente>(clienteAntigo, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable long id){
        var clienteAntigo = service.findById(id);
        if(clienteAntigo.getId() == 0){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Cliente>(clienteAntigo, HttpStatus.OK);
    }
}
