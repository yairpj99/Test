package org.banbajio.backend.EjemploBanBajio.Controller;

import java.util.List;

import org.banbajio.backend.EjemploBanBajio.Exeptions.GlobalException;
import org.banbajio.backend.EjemploBanBajio.Models.BancoModel;
import org.banbajio.backend.EjemploBanBajio.Services.BancoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("bancos")
public class BancoController {
    
    @Autowired
    private BancoServices services;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<BancoModel>findAll(){
        return services.findAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public GlobalException save(@Valid @RequestBody BancoModel data){
        return services.createNew(data);
    }

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public ResponseEntity<String>eliminarRegistro(@PathVariable String id){
    boolean isDelete = services.deletebyid(id);
    if(isDelete){
        return ResponseEntity.ok("El registro ha sido eliminado");
    }else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El registro no fuen encontrado");
    }
}


@GetMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public ResponseEntity<BancoModel>findById(@PathVariable String id){
    try{
        BancoModel model = services.findbyid(id);
        return ResponseEntity.ok(model);
    }catch(GlobalException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

}


