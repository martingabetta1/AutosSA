<<<<<<< HEAD
package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Marca;

import java.util.List;

public interface IMarcaService {

    List<Marca> listarMarcas();

    Marca listarMarcaPorId(Integer marcaId);
    Marca registrar(Marca marca);

   void actualizar(Integer marcaId, String nombre);

    void eliminar(Integer id);
=======
package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Marca;

import java.util.List;

public interface IMarcaService {

    List<Marca> listarMarcas();

    Marca listarMarcaPorId(Integer marcaId);
    Marca registrar(Marca marca);

   void actualizar(Integer marcaId, String nombre);

    void eliminar(Integer id);
>>>>>>> origin/backend
}