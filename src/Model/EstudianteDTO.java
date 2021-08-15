//DTO
package Model;
import java.io.File;
import java.util.ArrayList;

public class EstudianteDTO{

    private EstudianteDAO estudianteDAO;//elemento que llama las funciones del DAO

    //constructor para inicializar a esos atributos del DTO
    public EstudianteDTO(){
        estudianteDAO = new EstudianteDAO();
    }

    public void setEstudianteDAO(EstudianteDAO estudianteDAO){
        this.estudianteDAO= estudianteDAO;
    }

    public EstudianteDAO getEstudianteDAO(){
        return estudianteDAO;
    }

}



