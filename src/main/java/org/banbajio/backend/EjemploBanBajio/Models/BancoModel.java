package org.banbajio.backend.EjemploBanBajio.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "bancos")
public class BancoModel {
    @Id
    private String id;
    @NotBlank
    private String strNombre;
    @NotBlank
    private String strResponsable; 
}
