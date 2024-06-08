package com.Gerar.ApiFinal.demo.mocks;
import com.Gerar.ApiFinal.demo.Model.Autor;
public class AutorMocks {

    public static Autor mockEntity(){
        Autor autor = new Autor();
        autor.setId(1L);
        autor.setPersona(PersonaMock.mockEntity());
        autor.setLibros(LibroMock.mockList());
        return autor;
    }
}
}
