package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador.MapeadorInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador.MapeadorUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    private final RepositorioRolJpa repositorioRolJpa;
    private final MapeadorUsuario mapeadorUsuario;
    private final MapeadorInformacionUsuario mapeadorInformacionUsuario;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;

    public RepositorioUsuarioMySQL(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioRolJpa repositorioRolJpa,
                                   MapeadorUsuario mapeadorUsuario, MapeadorInformacionUsuario mapeadorInformacionUsuario,
                                   RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioRolJpa = repositorioRolJpa;
        this.mapeadorUsuario = mapeadorUsuario;
        this.mapeadorInformacionUsuario = mapeadorInformacionUsuario;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    public List<DtoUsuarioResumen> listar() {
        var entidadUsuarios =this.repositorioUsuarioJpa.findAll();
        return this.mapeadorUsuario.listarDominio(entidadUsuarios);
    }
    @Override
    public DtoUsuarioResumen consultarPorId(Long id) {
        var entidad = this.repositorioUsuarioJpa.findById(id).orElse(null);
        var informacionEntidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        assert informacionEntidad != null;
        return this.mapeadorUsuario.mapeadorDominioUsuario(entidad,informacionEntidad);
    }

    @Override
    public InformacionUsuario consultarPorIdParaMofdificar(Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorInformacionUsuario.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Usuario usuario, Rol rol, InformacionUsuario informacionUsuario) {
        var usuarioEntidad = this.mapeadorUsuario.mapeadorEntidad(usuario);
        var infusuarioEntidad = this.mapeadorInformacionUsuario.mapeadorEntidad(informacionUsuario);


        this.repositorioUsuarioJpa.save(usuarioEntidad);

        EntidadUsuarioRol entidadUsuarioRol = new EntidadUsuarioRol();
        entidadUsuarioRol.setUsuario(usuarioEntidad);
        entidadUsuarioRol.setIdUsuario(usuarioEntidad.getIdUsuario());  // Utilizar el ID generado
        entidadUsuarioRol.setRol(rol.getNombreRol());

        this.repositorioInformacionUsuarioJpa.save(infusuarioEntidad);
        this.repositorioRolJpa.save(entidadUsuarioRol);
        return usuarioEntidad.getIdUsuario();
    }


    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByCorreo(usuario.getCorreo()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioRolJpa.deleteById(id);
        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Usuario consultar(String correo, String password) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByCorreoAndPassword(correo, password);

        if(entidadUsuario == null) {
            return null;
        }

        List<Rol> roles = entidadUsuario.getRoles().stream().map(rol -> Rol.of(rol.getIdUsuario(), rol.getRol())).toList();

        return Usuario.of(entidadUsuario.getIdUsuario(), entidadUsuario.getNombre(), entidadUsuario.getApellido(), entidadUsuario.getCorreo(), entidadUsuario.getPassword(),
                entidadUsuario.getIdCargo(),roles);
    }

    @Override
    public Long modificar(Usuario usuario, InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorUsuario.actualizarEntidad(entidad, usuario);
        return this.repositorioUsuarioJpa.save(entidad).getIdUsuario();
    }

    @Override
    public Long modificarDireciones(InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorInformacionUsuario.actualizarDirecciones(entidad,informacionUsuario);
        return this.repositorioInformacionUsuarioJpa.save(entidad).getIdInformacionUsuario();
    }

    @Override
    public Long modificarDirecionesParaEliminar(InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorInformacionUsuario.eliminarDirecciones(entidad,informacionUsuario);
        return this.repositorioInformacionUsuarioJpa.save(entidad).getIdInformacionUsuario();
    }

    @Override
    public Long modificarProcesos(InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorInformacionUsuario.actualizarProcesos(entidad,informacionUsuario);
        return this.repositorioInformacionUsuarioJpa.save(entidad).getIdInformacionUsuario();
    }

    @Override
    public Long modificarProcesosParaEliminar(InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorInformacionUsuario.eliminarProcesos(entidad,informacionUsuario);
        return this.repositorioInformacionUsuarioJpa.save(entidad).getIdInformacionUsuario();
    }

    @Override
    public String obtenerDireccionDelUsuario(String correo) {
        return this.mapeadorInformacionUsuario.obtenerDirecccion(correo);
    }

    @Override
    public String obtenerProcesoDelUsuario(String correo) {
        return this.mapeadorInformacionUsuario.obtenerProceso(correo);
    }
}
