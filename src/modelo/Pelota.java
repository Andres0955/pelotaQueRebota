package modelo;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Pelota {
    private int x, y;
    private int radio;
    private int velocidadx, velocidady;
    private int anchoPanel, altoPanel;

    public Pelota(int x, int y, int radio, int velocidadx, int velocidady, int anchoPanel, int altoPanel) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.velocidadx = velocidadx;
        this.velocidady = velocidady;
        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;
    }

    public void mover(Barra barra){
        x += velocidadx;
        y += velocidady;

        //Detectar bordes y cambian direccion
        if(x - radio < 0 || x + radio > anchoPanel){
            velocidadx = -velocidadx;
        }
        if(y - radio < 0 ){
            velocidady = -velocidady;
        }
        //Detectar colision con la barra y rebotar
        if (y + radio >= barra.getY() && y + radio <= barra.getY() + barra.getAltura() &&
                x + radio >= barra.getX() && x - radio <= barra.getX() + barra.getBase()) {
            velocidady = -velocidady;
            y = barra.getY() - radio;

            try {
                File archivoSonido = new File("src/recursos/sonidoRebote.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
        //Detectar parte inferior del frame
        if (y + radio > altoPanel) {
            x = anchoPanel / 2;
            y = altoPanel / 2;

            try {
                File archivoSonido = new File("src/recursos/sonidoPerder.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getRadio(){
        return radio;
    }

    public int getAnchoPanel(){
        return anchoPanel;
    }

    public int getAltoPanel(){
        return altoPanel;
    }

}
