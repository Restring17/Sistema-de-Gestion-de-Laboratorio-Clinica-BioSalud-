/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import dao.UsuarioDao;
import entity.UsuarioTo;

/**
 * Controller para Usuario.
 *
 * PATRONES Y PRINCIPIOS:
 *  - SRP: Solo la responsabilidad de mediar entre UI y DAO de usuarios.
 *  - OCP, LSP, ISP, DIP: aplican.
 *  - FACADE: Simplifica operaciones de autenticación/gestión de usuarios.
 *  - FACTORY METHOD: creación del DAO puede delegarse.
 *  - STRATEGY: Lugar donde aplicar estrategias de autenticación o políticas de contraseña.
 *  - ADAPTER: Punto para adaptar usuarios desde LDAP o directorios externos.
 */
public class UsuarioController {

    private UsuarioDao dao;

    public UsuarioController() {
        dao = new UsuarioDao();
    }

    public List<UsuarioTo> UsuarioListar() throws Exception {
        return dao.readAll();
    }

    public UsuarioTo UsuarioBuscar(Object o) throws Exception {
        return dao.find(o);
    }

    public UsuarioTo UsuarioPorNombre(String nombre) throws Exception {
        return dao.findByNombre(nombre);
    }

    public void UsuarioAdicionar(UsuarioTo o) throws Exception {
        dao.create(o);
    }

    public void UsuarioActualizar(UsuarioTo o) throws Exception {
        dao.update(o);
    }

    public void UsuarioEliminar(UsuarioTo o) throws Exception {
        dao.delete(o);
    }
}
