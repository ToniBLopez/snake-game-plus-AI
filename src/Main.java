
package Code;

import processing.core.*;

public class Main extends PApplet{

    public static void main(String[] args) {
        PApplet.main(new String[]{Code.Main.class.getName()});
    }

    int filas = 25;
    int columnas = 25;
    int bs = 20;

    boolean map[][] = new boolean[filas][columnas];
    Apple apple = new Apple();
    boolean greenBox = true;
    boolean purpleBox = true;

    @Override
    public void settings() {
        size(500,400);
    }

    @Override
    public void setup() {
        frameRate(25);
        initGame();
    }

    @Override
    public void draw() {
        background(25);
        initGame();
        drawMap();
    }

    void initGame() {
        updateMap();
        apple.spawn(map);
    }

    void updateMap() {
        // Asignamos todo el mapa a true primero
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                map[i][j] = true;
            }
        }
    }

    void drawMap() {
        // Dibujamos el cuadro gris de abajo
        fill(100,100,100);
        rect(0,500,width,40);

        // Dibujamos las dos casillas del marcador
        fill(100,200,100);
        rect(30,510,210,210);

        fill(100,100,200);
        rect(270,510,210,20);
        if(greenBox == flase) {
            fill(250,50,50);
            rect(30,510,210,20);
        }
        if(purpleBox == false) {
            fill(250,50,50);
            rect(270,510,210,20);
        }
    }

    void drawApple() {
        fill(215,0,75);
        rect(apple.position.x * bs, apple.position.y * bs, bs, bs);
    }

    @Override
    public void mouseClicked() {
        // Comprueba si el click está en el cuadro verde. Si es así cambiará el estado del snake muerto-vivo
        if (mouseX >= 30 && mouseX <= 240 && mouseY >= 510 && mouseY <= 530) {
            greenBox = !greenBox;
        }

        // Comprueba si el click está en el cuadro morado.
        if (mouseX >= 30 && mouseX <= 240 && mouseY >= 510 && mouseY <= 530) {
            purpleBox = !purpleBox;
        }
    }

}
