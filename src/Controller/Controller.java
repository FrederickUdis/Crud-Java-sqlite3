//Clase Controller
package Controller;
import Vista.VistaConsola;
import Model.EstudianteDTO;


import java.io.File;

public class Controller {

    private VistaConsola vista;
    private EstudianteDTO instituto;// tiene un Arreglo, un DAO, un Archivo y un File

    public Controller(){
        vista = new VistaConsola();
        instituto = new EstudianteDTO();// estudiantes, EstudianteDAO
        //funcionar();
    }

    public void funcionar(){
        int opcion = 0;
        int c = 0, e = 0;

        String menu = "INSTITUTO LA FLORESTA" + "\n"+
                "Seleccione tarea a realizar:"+ "\n"+
                " 1. Ingresar estudiante"+ "\n"+
                " 2. Buscar estudiante"+ "\n"+
                " 3. Modificar estudiante"+ "\n"+
                " 4. Eliminar Estudiante"+ "\n"+
                " 5. Ver directorio de estudiantes"+ "\n"+
                " 6. Salir"+ "\n"+
                "Opción:";
        do{
            opcion = vista.leerDatoEntero(menu);
            switch(opcion){
                case 1:
                    ingresarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    mostrarDirectorio();
                    break;
                case 6:
                    vista.mostrarInformacion("\nHasta pronto");
                    break;
                default:
                    vista.mostrarInformacion("\nError: Opción no válida");
            }
        }while(opcion!=6);
    }

    public void ingresarEstudiante(){

        String n = "" , a = "", fn = "", ci = "", cp = "", pr = "";
        long cel = 0, f = 0;
        vista.mostrarInformacion("\nIngresar estudiante");
        n = vista.leerDatoString("Ingresar nombres: ");
        a = vista.leerDatoString("Ingresar apellidos: ");
        fn = vista.leerDatoString("Ingresar fecha de nacimiento (YYYY-MM-DD): ");
        ci = vista.leerDatoString("Ingresar correo institucional: ");
        cp = vista.leerDatoString("Ingresar correo personal: ");
        cel = vista.leerDatoLong("Ingresar número de celular: ");
        f = vista.leerDatoLong("Ingresar número fijo: ");
        pr = vista.leerDatoString("Ingresar programa: ");
        instituto.getEstudianteDAO().agregarEstudiante(1,n,a,fn,ci,cp,cel,f,pr);
        //System.out.println("estudiante agregado");
    }

    public void mostrarDirectorio(){
        vista.mostrarInformacion("\nEl directorio de los estudiantes");
        vista.mostrarInformacion(instituto.getEstudianteDAO().verEstudiantes());
    }

    public void buscarEstudiante(){
        String ci="";
        vista.mostrarInformacion("\nBuscar estudiante");
        ci=vista.leerDatoString("\nIngresar correo institucional:");
        vista.mostrarInformacion(instituto.getEstudianteDAO().buscarEstudiante(ci));
    }

    public void eliminarEstudiante(){
        String ci="";
        vista.mostrarInformacion("\nEliminar estudiante");
        ci=vista.leerDatoString("\nIngresar correo institucional:");
        vista.mostrarInformacion(instituto.getEstudianteDAO().eliminarEstudiante(ci));
    }


    public void modificarEstudiante(){
        String cp="", pr="", ci="";;
        long cel = 0, f = 0;

        vista.mostrarInformacion("\nModificar estudiante");
        ci=vista.leerDatoString("\nIngresar correo institucional:");
        cp = vista.leerDatoString("Ingresar correo personal: ");
        cel = vista.leerDatoLong("Ingresar número de celular: ");
        f = vista.leerDatoLong("Ingresar número fijo: ");
        pr = vista.leerDatoString("Ingresar programa: ");

        vista.mostrarInformacion(instituto.getEstudianteDAO().modificarEstudiante(ci,cp,cel,f,pr));

    }

}
