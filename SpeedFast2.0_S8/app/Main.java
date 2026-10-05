package app;
import util.ConexionBD;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

    ConexionBD ConexionDB = null;
        if (!ConexionDB.existeDB()){

            System.err.println("Error de conexion, la base de datos no esta creada o no existe");

            System.err.println("Debes crear la base de datos antes de iniciar la aplicacion");

            System.exit(1);

        }else{
            System.out.println("Conexion establecida correctamente");
        }



        }
    }