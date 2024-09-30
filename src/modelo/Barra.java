package modelo;

public class Barra {
    private int x, y;
    private int base, altura;
    private int velocidadx;
    private int anchoPanel, altoPanel;

    public Barra(int x,int base, int altura, int velocidadx, int anchoPanel, int altoPanel) {
        this.x = x;
        this.base = base;
        this.altura = altura;
        this.velocidadx = velocidadx;
        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;
    }

    public void mover(int nuevaX) {
        if (nuevaX < 0) {
            x = 0;
        } else if (nuevaX + base > anchoPanel) {
            x = anchoPanel - base;
        } else {
            x = nuevaX;
        }
    }


    public void moverIzquierda() {
        if(x - velocidadx > 0){
            x = x - velocidadx;
        }else{
            x = 0;
        }
    }

    public void moverDerecha(){
        if(x + base + velocidadx < anchoPanel){
            x = x + velocidadx;
        }else{
            x = anchoPanel - base;
        }
    }

    public int getX(){
        return x;
    }


    public int getBase(){
        return base;
    }

    public int getAltura(){
        return altura;
    }

    public int getY() {
        return altoPanel - altura;
    }
}
