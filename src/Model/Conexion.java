//Conexion
package Model;
import java.sql.*;

public class Conexion {
    private Connection con = null;

    public void Conectar() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Frederick\\eclipse-workspace\\Reto-4\\src\\data_p1.db");
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("No se ha logrado la conexion");
        }
    }

    public String Traerbd() {
        Conectar();
        String datos = "";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Estudiantes;");
            while (rs.next()) {

                datos = datos + "Nombres: " + rs.getString("Nombres") + "\n" +
                        "Apellidos: " + rs.getString("Apellidos") + "\n" +
                        "Fecha nacimiento: " + rs.getString("Fecha") + "\n" +
                        "Correo institucional: " + rs.getString("Correoins") + "\n" +
                        "Correo personal: " + rs.getString("Correoper") + "\n" +
                        "Número de teléfono celular: " + rs.getString("tel") + "\n" +
                        "Número de teléfono fijo: " + rs.getString("cel") + "\n" +
                        "Programa académico: " + rs.getString("programa") + "\n";
            }
            return datos;
        } catch (SQLException sqle) {
            System.out.println("No se ha logrado la operacion");
        }
        return datos;
    }

    public String buscar(String correoinst) {
        Conectar();
        String datos = "";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Estudiantes where Correoins = '" + correoinst + "';");

            while (rs.next()) {

                datos = "Nombres: " + rs.getString("Nombres") + "\n" +
                        "Apellidos: " + rs.getString("Apellidos") + "\n" +
                        "Fecha nacimiento: " + rs.getString("Fecha") + "\n" +
                        "Correo institucional: " + rs.getString("Correoins") + "\n" +
                        "Correo personal: " + rs.getString("Correoper") + "\n" +
                        "Número de teléfono celular: " + rs.getString("tel") + "\n" +
                        "Número de teléfono fijo: " + rs.getString("cel") + "\n" +
                        "Programa académico: " + rs.getString("programa");
            }
            return datos;
        } catch (SQLException sqle) {
            System.out.println("No se ha logrado la operacion");
        }
        return datos;
    }

    public void ingresadatos(String valores) {
        Conectar();
        try {
            PreparedStatement stm = null;
            stm = con.prepareStatement("INSERT INTO Estudiantes (Id, Nombres, Apellidos, Fecha, Correoins, Correoper, tel, cel, programa)" +
                    "VALUES(" + valores + ");");
            stm.executeUpdate();
            //id+","+nombres+","+apellidos+","+fecha+","+correoi+","+corrreop+","+cel+","+tel+","+prog
        } catch (SQLException sqle) {
            System.out.println("No se ha logrado la operacion");
        }
    }

    public void modificadatos(String valores) {
        Conectar();
        try {
            PreparedStatement stm = null;
            stm = con.prepareStatement("UPDATE Estudiantes SET " +valores+";");
            stm.executeUpdate();
            //id+","+nombres+","+apellidos+","+fecha+","+correoi+","+corrreop+","+cel+","+tel+","+prog
        } catch (SQLException sqle) {
            System.out.println("No se ha logrado la operacion");
        }
    }

    public void eliminardatos(String valor){
        Conectar();
        try {
            PreparedStatement stm = null;
            stm = con.prepareStatement("DELETE FROM Estudiantes WHERE Correoins = '"+valor+"';");
            stm.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("No se ha logrado la operacion");
        }
    }


}


/*

 create table Estudiantes(
 Id INTEGER(20),
 Nombres TEXT NOT NULL,
 Apellidos TEXT NOT NULL,
 Fecha TEXT NOT NULL,
 Correoins TEXT NOT NULL,
 Correoper TEXT NOT NULL,
 tel TEXT NOT NULL,
 cel TEXT NOT NULL,
 programa TEXT NOT NULL);

INSERT INTO Estudiantes(Id, Nombres, Apellidos, Fecha, Correoins, Correoper, tel, cel, programa)
VALUES(1,'Pepe','Perez','1980-05-29','lpovedag@lafloresta.edu.co','lpovedag@hotmail.com','876543','23456','Ingenieria');
VALUES(2,'Mayra','Castaño','1989-06-20','mcast@lafloresta.edu.co','mcast@gmail.com','300876543','9923456','Matematicas');
VALUES(3,'Maria','Castro','1990-06-20','mcastro@lafloresta.edu.co','mcastro@gmail.com','300876543','9923456','Matematicas');}
*/
