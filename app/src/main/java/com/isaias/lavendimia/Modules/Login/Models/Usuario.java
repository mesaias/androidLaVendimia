package com.isaias.lavendimia.Modules.Login.Models;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Usuario implements Serializable {

    private Integer id;

    private Date fechaPin;

    private Integer idPlaza;

    private Integer idProspecto;

    private Integer idSucursal;

    private String statuspin;

    private String usuarioActivo;

    private String apellidoMaterno;

    private String apellidoPaterno;

    private String autorizaBonificacionAdicional;

    private String autorizaCancelaAbono;

    private String autorizaConciliacion;

    private String autorizaPrestamo;

    private String autorizaStatusproceso;

    private String ciudad;

    private String codigoPostal;

    private String colonia;

    private String correo;

    private String cuentaAnticipo;

    private String cuentaContable;

    private String domicilio;

    private String username;

    private String estado;

    private Integer extension;

    private Date fechaAlta;

    private Date fechaNacimiento;

    private Date fechaPassword;

    private String huellaLogin;

    private String integraPlazas;

    private String nivel;

    private String nombre;

    private String password;

    private String permisoColaboradores;

    private Integer idSucursalOriginal;

    private String puesto;

    private String rutaFoto;

    private String tarjeta;

    private String telefono;

    private String tipoUsuario;

    private String pin;

    private boolean cambiarPassword;

    private boolean cambiarPin;
}
