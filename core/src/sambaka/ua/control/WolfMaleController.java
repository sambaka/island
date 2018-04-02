package sambaka.ua.control;


import com.badlogic.gdx.math.Polygon;

import java.util.Random;

public class WolfMaleController {
    private Polygon wolfBounds;
    private Random r = new Random();
    private float posX;
    private float posY;
    private int dx;
    private int dy;


    public WolfMaleController(Polygon wolfBounds) {
        this.wolfBounds = wolfBounds;
        this.posX = wolfBounds.getX();
        this.posY = wolfBounds.getY();
    }

    private int generateDxDy(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    ///дописать рандомное перемещение по клеткам
    public void move() {
        if(posX<=0){
            dx=generateDxDy(0,1);
            posX+=(30f*dx);
        }else if(posX>=570f){
            dx=generateDxDy(-1,0);
            posX+=(30f*dx);
        }else {
            dx=generateDxDy(-1,1);
            posX+=(30f*dx);
        }
        System.out.println("dx="+dx+", posX="+posX);
        if(posY<=0){
            dy=generateDxDy(0,1);
            posY+=(30f*dy);
        }else if(posY>=570f){
            dy=generateDxDy(-1,0);
            posY+=(30*dy);
        }else {
            dy=generateDxDy(-1,1);
            posY+=(30*dy);
        }
        System.out.println("dy="+dy+", posY="+posY);
        wolfBounds.setPosition(posX,posY);
    }

    public void handle() {
        // wolfBounds.setPosition(wolfBounds.getX(), wolfBounds.getY() + 0.2f * GameScreen.DELTACFF);

    }
}
