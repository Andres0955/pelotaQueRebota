import controlador.Control;
import modelo.Barra;
import modelo.Pelota;
import vista.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int ancho = 800;
        int alto = 600;



        JFrame marco = new JFrame("Pelota que robota");
        //marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pelota pelota = new Pelota(100, 100, 25, 10, 10, ancho, alto);
        Barra barra = new Barra(350, 150, 20, 30, ancho, alto);
        Interfaz interfaz = new Interfaz(pelota, barra);
        interfaz.setPreferredSize(new Dimension(ancho, alto));
        Control control = new Control(pelota, interfaz, barra, marco);

        marco.add(interfaz);
        marco.pack();
        marco.setVisible(true);

        control.iniciar();
    }
}