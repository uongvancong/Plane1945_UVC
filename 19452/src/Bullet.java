import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Bullet extends GameObject {
    private int speed;

    private Bullet() {
        positionX = 0;
        positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\Code\\Plane1945_UVC\\19452\\Resources\\DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move() {
        this.positionY -= this.speed;
    }

    public void update() {
        this.move();

    }

    //check va cham PlaneMoveByKey  cua Enem
    public boolean checkCollision() {
        Rectangle rectBullet = new Rectangle(positionX, positionY, sprite.getWidth()
                , sprite.getHeight());

        Rectangle rectPlaneKey =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
        return rectBullet.intersects(rectPlaneKey);
    }

    //check va cham PlaneMoveByMouse vd Bullet cua Enemy
    public boolean checkCollision1() {
        Rectangle rectBullet = new Rectangle(positionX, positionY, sprite.getWidth()
                , sprite.getHeight());
        Rectangle rectPlaneMouse =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        return rectBullet.intersects(rectPlaneMouse);
    }

    //check va cham PlaneEnemy vs Bullet cua Plane
    public void checkCollision2() {
        Rectangle rectBullet = new Rectangle(positionX, positionY, sprite.getWidth()
                , sprite.getHeight());
//        Vector<Rectangle> rectangleVector = new Vector<>();
        for (int i = 0; i < PlaneEnemyManager.getInstance().getVectorPlaneEnemy().size(); i++) {
            Rectangle rectPlaneEnemy = new Rectangle(PlaneEnemyManager.getInstance().getVectorPlaneEnemy().get(i).getPositionX(), PlaneEnemyManager.getInstance().getVectorPlaneEnemy().get(i).getPositionY(), PlaneEnemyManager.getInstance().getVectorPlaneEnemy().get(i).getSprite().getWidth(), PlaneEnemyManager.getInstance().getVectorPlaneEnemy().get(i).getSprite().getHeight());
            if(rectBullet.intersects(rectPlaneEnemy)){
                PlaneEnemyManager.getInstance().getVectorPlaneEnemy().remove(i);

            }
        }
    }


    //Lay toa do cua 2 may bay
    //PlaneManager.getInstance()....


    public void draw(Graphics g) {
        g.drawImage(sprite, positionX, positionY, null);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
