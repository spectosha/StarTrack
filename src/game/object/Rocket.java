package game.object;

import main.state.LevelState;

import java.awt.*;

public class Rocket extends Bullet{
        int[][] way;
    public Rocket(LevelState ls, GameObject go, int x, int y){
        super(ls, go, x, y);
        Player pl = ls.player;
        way = new int[(Panel.HEIGHT-y)][2];
        double kx = pl.x-x;
        double ky = pl.y-y;
        double G = Math.pow(kx,2) + Math.pow(ky-y,2);
        G = Math.sqrt(G);
        double dx = pl.x+kx/2-ky/4;
        double dy = pl.y+ky/2-kx/4;

        double angle = Math.atan(ky/kx)-90d;



    }

    public void update(){

    }

    public void draw(Graphics2D g){

    }
}
