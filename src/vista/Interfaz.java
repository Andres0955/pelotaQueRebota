package vista;
import modelo.*;
import javax.swing.*;
import java.awt.*;

public class Interfaz extends JPanel {
    private Pelota pelota;
    private Barra barra;
    private Image fondo;

    public Interfaz(Pelota pelota, Barra barra) {
        this.pelota = pelota;
        this.barra = barra;
        fondo = new ImageIcon("src/recursos/fondo2.jpeg").getImage(); // Cambia a fondo.png
        setPreferredSize(new Dimension(pelota.getRadio() * 2,pelota.getRadio() * 2));

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, pelota.getAnchoPanel(), pelota.getAltoPanel(), this);

        g.setColor(new Color(152, 154, 166));        g.fillOval(pelota.getX() - pelota.getRadio(), pelota.getY() - pelota.getRadio(),
                pelota.getRadio() * 2, pelota.getRadio() * 2);

        g.setColor(new Color(192, 192, 192));
        g.fillRect(barra.getX(), barra.getY(), barra.getBase(), barra.getAltura());

    }

    public void actualizarPanel(){
        repaint();
    }

}
