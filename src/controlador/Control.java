package controlador;

import vista.Interfaz;
import modelo.*;
import javax.swing.*;
import java.awt.event.*;

public class Control {
    private Pelota pelota;
    private Interfaz interfaz;
    private Barra barra;
    private javax.swing.Timer temporizador;

    public Control(Pelota pelota, Interfaz interfaz, Barra barra, JFrame marco) {
        this.pelota = pelota;
        this.interfaz = interfaz;
        this.barra = barra;

        temporizador = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelota.mover(barra);
                interfaz.actualizarPanel();
            }
        });

        marco.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    barra.moverIzquierda();
                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    barra.moverDerecha();
                }
                interfaz.actualizarPanel();

            }
        });

        marco.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                barra.mover(e.getX());
            }
        });
        //marco.setFocusable(true);
        //marco.requestFocusInWindow();


    }

    public void iniciar() {
        temporizador.start();
    }

    public void detener() {
        temporizador.stop();
    }

}
