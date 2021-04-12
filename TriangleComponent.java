import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TriangleComponent extends JComponent
{
    private static final int MAX_POINTS = 3;
    private static int state = 0;
    /*
        0 - nothing
        1 - dot
        2 - line
        3 - triangle
     */

    private static int x;
    private static int y;
    private static int x2;
    private static int y2;
    private static int x3;
    private static int y3;


    public TriangleComponent()
    {
        MouseListener listener = new MousePressListener();
        this.addMouseListener(listener);


    }

    @Override
    public void paintComponent(Graphics g)
    {  
        super.paintComponent( g );
        Graphics2D g2 = (Graphics2D) g;
        if(TriangleComponent.state == 0){
            g.drawLine(TriangleComponent.x,TriangleComponent.y,TriangleComponent.x,TriangleComponent.y);
            TriangleComponent.state ++;
        }
        else if(TriangleComponent.state == 1){
            g.drawLine(TriangleComponent.x,TriangleComponent.y,TriangleComponent.x2,TriangleComponent.y2);
            TriangleComponent.state ++;
        }
        else if(TriangleComponent.state == 2){
            g.drawLine(TriangleComponent.x,TriangleComponent.y,TriangleComponent.x2,TriangleComponent.y2);
            g.drawLine(TriangleComponent.x,TriangleComponent.y,TriangleComponent.x3,TriangleComponent.y3);
            g.drawLine(TriangleComponent.x2,TriangleComponent.y2,TriangleComponent.x3,TriangleComponent.y3);
            TriangleComponent.state ++;
        }
        else{
            TriangleComponent.state = 0;
        }


    }


    class MousePressListener implements MouseListener {

        public void mousePressed(MouseEvent event){
            if(TriangleComponent.state == 0){
                TriangleComponent.x = event.getX();
                TriangleComponent.y = event.getY();}
            else if(TriangleComponent.state == 1){
                TriangleComponent.x2 = event.getX();
                TriangleComponent.y2 = event.getY();
            }
            else if(TriangleComponent.state == 2){
                TriangleComponent.x3 = event.getX();
                TriangleComponent.y3 = event.getY();
            }
            repaint();




        }

        //do nothing methods
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
    }

}