package api;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class gui extends JFrame {

        public gui() throws HeadlessException {
            this.add(new GraphP());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500,500);
//          this.add(new GraphP());
            this.setVisible(true);
        }

        public  class GraphP extends JPanel implements MouseListener {
            LinkedList<Point2D> points=new LinkedList<Point2D>();

            public GraphP() {
                this.addMouseListener(this);
            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Point2D p=new Point2D.Double(e.getX(),e.getY());
                points.add(p);
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Point2D prev=null;
                for (Point2D p:points) {
                    g.setColor(new Color(234, 26, 171));
                    g.fillOval((int)p.getX()-10,(int)p.getY()-10,20,20);
                    if(prev!=null){
                        Double dist = p.distance(prev);
                        String distS = dist.toString().substring(0,dist.toString().indexOf(".")+2);
                        g.drawLine((int)p.getX(),(int)p.getY(),(int)prev.getX(),(int)prev.getY());
                        g.drawString(distS, (int)((p.getX()+prev.getX())/2),(int)((p.getY()+prev.getY())/2));
                    }
                    prev=p;

                }

            }
        }

        public static void main(String[] args) {
            new gui();
        }
    }

