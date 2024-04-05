package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.impl;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuarioRol;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador.MapeadorInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador.MapeadorUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioRolJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
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
    public InformacionUsuario consultarPorIdParaModificar(Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        return this.mapeadorInformacionUsuario.mapeadorDominio(entidad);
    }

    @Override
    public Long guardar(Usuario usuario, Rol rol, InformacionUsuario informacionUsuario)  {
        try {
            // Guardar la entidad de usuario y obtener el ID generado
            var usuarioEntidad = this.mapeadorUsuario.mapeadorEntidad(usuario);
            usuarioEntidad = this.repositorioUsuarioJpa.save(usuarioEntidad);
            var idUsuarioGenerado = usuarioEntidad.getIdUsuario();

            // Utilizar el mismo ID generado para la entidad de información de usuario
            var infUsuarioEntidad = this.mapeadorInformacionUsuario.mapeadorEntidad(informacionUsuario);
            infUsuarioEntidad.setIdInformacionUsuario(idUsuarioGenerado);
            // Crear y guardar la entidad de UsuarioRol
            EntidadUsuarioRol entidadUsuarioRol = new EntidadUsuarioRol();
            entidadUsuarioRol.setIdUsuario(usuarioEntidad.getIdUsuario());
            entidadUsuarioRol.setUsuario(usuarioEntidad);  // Asignar el usuario antes de guardarlo
            entidadUsuarioRol.setNombreRol(rol.getNombreRol());
            this.repositorioRolJpa.save(entidadUsuarioRol);

            // Guardar la entidad de información de usuario
            this.repositorioInformacionUsuarioJpa.save(infUsuarioEntidad);

            return idUsuarioGenerado; // Devolver el ID generado
        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante el proceso
            throw new IllegalArgumentException(Mensaje.SE_HA_PRESENTADO_UN_ERROR_AL_GUARDAR_EL_USUARIO);
        }
    }

    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByCorreo(usuario.getCorreo()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        // Elimina la entidad de roles del usuario
        this.repositorioRolJpa.eliminarRolesPorUsuarioId(id);
        // Ahora puedes eliminar el usuario
        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Usuario consultar(String correo, String password) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByCorreoAndPassword(correo, password);

        if(entidadUsuario == null) {
            return null;
        }
        List<Rol> roles = entidadUsuario.getRoles().stream().map(rol -> Rol.of(rol.getIdUsuario(), rol.getNombreRol())).toList();

        return Usuario.of(entidadUsuario.getIdUsuario(), entidadUsuario.getNombre(), entidadUsuario.getApellido(), entidadUsuario.getCorreo(), entidadUsuario.getPassword(),
                entidadUsuario.getIdCargo(),roles);
    }

    @Override
    public Long modificar(Usuario usuario, Rol rol, InformacionUsuario informacionUsuario, Long id) {
        // Obtener la entidad Usuario
        var entidadUsuario = this.repositorioUsuarioJpa.findById(id).orElse(null);
        assert entidadUsuario != null;

        mapeadorUsuario.actualizarEntidad(entidadUsuario,usuario);

        // Buscar la entidad EntidadUsuarioRol correspondiente al usuario
        EntidadUsuarioRol entidadUsuarioRol = this.repositorioRolJpa.findByIdUsuario(id);

        // Verificar si la entidad EntidadUsuarioRol existe
        if (entidadUsuarioRol != null) {
            // Si existe, eliminar la entidad existente
            this.repositorioRolJpa.delete(entidadUsuarioRol);
        }

        // Crear una nueva instancia de EntidadUsuarioRol
        EntidadUsuarioRol nuevoUsuarioRol = new EntidadUsuarioRol();
        nuevoUsuarioRol.setIdUsuario(id);
        nuevoUsuarioRol.setUsuario(entidadUsuario);
        nuevoUsuarioRol.setNombreRol(rol.getNombreRol());

        // Guardar la nueva instancia de EntidadUsuarioRol
        this.repositorioRolJpa.save(nuevoUsuarioRol);

        // Retornar el ID del usuario
        return entidadUsuario.getIdUsuario();
    }



    @Override
    public Long modificarAgregarPass(Usuario usuario, InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorUsuario.actualizarPass(entidad, usuario);
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
    public Long modificarPats(InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorInformacionUsuario.actualizarPats(entidad,informacionUsuario);
        return this.repositorioInformacionUsuarioJpa.save(entidad).getIdInformacionUsuario();
    }

    @Override
    public Long modificarPatParaEliminar(InformacionUsuario informacionUsuario, Long id) {
        var entidad = this.repositorioInformacionUsuarioJpa.findById(id).orElse(null);
        assert entidad != null;
        this.mapeadorInformacionUsuario.eliminarPats(entidad,informacionUsuario);
        return this.repositorioInformacionUsuarioJpa.save(entidad).getIdInformacionUsuario();
    }

    @Override
    public Long obtenerIdUsuarioDelUsuario(String correo) {
        return this.mapeadorInformacionUsuario.obtenerIdUsuario(correo);
    }

    @Override
    public List<String> obtenerDireccionesDelUsuario(String correo) {
        return this.mapeadorInformacionUsuario.obtenerDirecciones(correo);
    }

    @Override
    public List<String> obtenerPatsDelUsuario(String correo) {
        return this.mapeadorInformacionUsuario.obtenerPats(correo);
    }
}
