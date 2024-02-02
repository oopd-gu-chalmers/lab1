import javax.swing.*;
import java.awt.*;

public class JPanel extends javax.swing.JPanel implements Runnable {
    private int width = 800;
    private int height = 600;
    private BilTransport car;
    int playerX = 400;
    int playerY = 100;
    int FPS = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    public JPanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null) {

            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime= remainingTime/1000000;
                if(remainingTime<0) {
                    remainingTime=0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(keyH.upPressed) {
            car.gas(0.3);
           // playerY += 10;
        }
        if(keyH.downPressed) {
           car.brake(0.3);
            //playerY -=10;
        }
        if(keyH.rightPressed) {
            car.turnright();
            //playerX += 10;
        }
        if(keyH.leftPressed) {
            car.turnleft();
           // playerX -= 10;;
        }
        car.move();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.blue);
        g2.fillRect((int) car.getxPos(), (int) car.getyPos(), 15, 15);
        g2.dispose();
    }


}
