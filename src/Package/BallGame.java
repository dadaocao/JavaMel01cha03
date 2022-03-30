package Package;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {

    Image ball=Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.png");


    double x=200;
    double y=200;

    double degree=3.14/3;//弧度。3.14=180°。除以三就是60°
    //测试：boolean right=true;控制小球水平移动方向
    //绘制窗口
    public void paint(Graphics g){
        System.out.println("窗口被画了一次！");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x=x+10*Math.cos(degree);
        y=y+10*Math.sin(degree);

        //碰到上下边界：
        if (y>501-30-40||y<40){
            degree=-degree;
        }
        //碰到左右边界；
        if(x>856-30-40||x<40){
            degree=3.14-degree;
        }
        /*
        if(right) {
            x = x + 10;
        }else{
            x=x-10;
        }
        if(x>856-30-40){
            right=false;
        }

        if(x<40){
            right=true;
        }
        测试水平移动 用不上了
        */


    }

    //创建窗口
    void launchFrame(){
        setSize(856, 501);
        setLocation(100,100);
        setVisible(true);




        //实现动画，每秒绘制窗口25次；
        while(true){
            repaint();

            try {
                Thread.sleep(40); //1s=1000ms；大约1秒绘制1000/40=25次；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main (String[] args){
        System.out.println ("我的小游戏要开始了！");

        BallGame game=new BallGame();
        game.launchFrame();

    }
}