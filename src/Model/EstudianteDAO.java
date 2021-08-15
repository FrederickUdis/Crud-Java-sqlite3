//DAO
package Model;

import java.io.IOException;
import java.util.ArrayList;

import java.io.File;

public class EstudianteDAO{
    private Conexion conexion;//= new Conexion();

    public EstudianteDAO(){}
    public EstudianteDAO(Conexion con){con = new Conexion();}

    public String verEstudiantes(){
        String datos="";
        try{
            conexion = new Conexion();
            datos = conexion.Traerbd();
            //System.out.println("Conectado y con datos");
            return datos;
        }catch(Exception e){return "No hay data";}
    }

    public void agregarEstudiante(int id, String nombres, String apellidos, String fecha_nacimiento, String correo_institucional, String correo_personal, long celular, long fijo, String programa){
        String datos="";
        datos=id+",'"+nombres+"','"+apellidos+"','"+fecha_nacimiento+"','"+correo_institucional+"','"+correo_personal+"','"+celular+"','"+fijo+"','"+programa+"'";
        try{
            conexion = new Conexion();
            conexion.ingresadatos(datos);
            System.out.println("estudiante agregado");
            //System.out.println("Conectado y con datos");
        }catch(Exception e){System.out.println("estudiante no agregado");}
    }

    public String buscarEstudiante(String correo){
        String datos="";
        try{
            conexion = new Conexion();
            datos = conexion.buscar(correo);
            System.out.println("Conectado y con datos");
            return datos;
        }catch(Exception e){return "No hay data";}
    }

    public String eliminarEstudiante(String correo){
            try {
                conexion = new Conexion();
                conexion.eliminardatos(correo);
                return "\nSe eliminó el estudiante";
        }catch(Exception ioe){}
        return "\nNo se eliminó el estudiante";
    }

    public String modificarEstudiante(String correo, String correo_personal, long celular, long fijo, String programa){
        String datos = "Correoper='"+correo_personal+"', tel='"+celular+"', cel='"+fijo+"', programa='"+programa+"' WHERE Correoins='"+correo+"'";
        try{
            conexion = new Conexion();
            conexion.modificadatos(datos);
            return "\nSe modificó el estudiante";
        }catch(Exception ioe){}
        return "\nNo se modificó el estudiante";
    }

    public Conexion getConexion(){return conexion;}

}


