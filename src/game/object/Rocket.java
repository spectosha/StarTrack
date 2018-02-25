package game.object;

import main.state.LevelState;

import java.awt.*;

public class Rocket extends Bullet{
        int[][] way;
    public Rocket(LevelState ls, GameObject go, int x, int y){
        super(ls, go, x, y);
        way = new int[Panel.HEIGHT/3][2];

    }

    public void update(){

    }

    public void draw(Graphics2D g){
        drawPixels(g);
    }
}
