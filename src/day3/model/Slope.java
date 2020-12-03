package day3.model;

public class Slope{
    int positionX = 0;
    int positionY = 0;
    int moveX;
    int moveY;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Slope(int right){
        this(right, 1);
    }

    public Slope(int right, int down){
        moveX = right;
        moveY = down;
    }

    public void move(){
        positionX += moveX;
        positionY += moveY;
    }
}