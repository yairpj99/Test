package org.banbajio.backend.EjemploBanBajio.Services;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.banbajio.backend.EjemploBanBajio.Exeptions.GlobalException;
import org.banbajio.backend.EjemploBanBajio.Models.BancoModel;
import org.banbajio.backend.EjemploBanBajio.Repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BancoServices {

    @Autowired
    private BancoRepository repository;

    public List<BancoModel>findAll(){
        return repository.findAll();
    }

    public BancoModel findbyid(String id){
        Optional<BancoModel> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new GlobalException("No se encontraron resultados");
        }
    }

    @Transactional
    public boolean deletebyid(String id){
        Optional<BancoModel> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public GlobalException createNew(BancoModel data){
        try{
            repository.save(data);
            throw new GlobalException("El objeto ha sido guardado con exito"); 
        }catch(Exception exception){
            throw new GlobalException(exception.getMessage());
        }
    }
 

}
