import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.QuadCurve2D;


public class PlotGraph extends JComponent {

    public void paint(Graphics g)
    {

        int w = this.getWidth()/2;
        int h = this.getHeight()/2;

        //XY Axis
        Graphics2D drawXY = (Graphics2D) g;
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON //antialiasing for XY axis
        );
        drawXY.setRenderingHints(hints);
        drawXY.setColor(Color.WHITE);
        drawXY.setStroke(new BasicStroke(3));

        drawXY.drawLine(0, h,w * 2, h); //X axis
        drawXY.drawLine(w,0, w, h*2); // Y axis

        Graphics2D XYstring = (Graphics2D) g;

        //XY Strings
        XYstring.setColor(Color.WHITE);
        XYstring.setStroke(new BasicStroke(1));


        //Drawing Quadratic Graph
        Graphics2D drawGraph = (Graphics2D) g;

        drawGraph.setColor(Color.CYAN);
        drawGraph.setStroke(new BasicStroke(2));
        Polygon pointer = new Polygon();

        for(int x = -300; x <= 300; x++)
        {
            pointer.addPoint(w + x, h - (10 * x * x + 30 * x + 3)/1000); //Drawing graph in the XY axis

        }
        drawGraph.drawPolyline(pointer.xpoints, pointer.ypoints, pointer.npoints);
    }


    public static void main(String[] args) {


        int width = 450;
        int height = 450;
        JFrame jf = new JFrame();
        jf.setSize(width, height);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setTitle("Patryk Barton 12525 C3");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes the compilation after the window is closed
        jf.getContentPane().setBackground(Color.BLACK); // black background

        PlotGraph graph = new PlotGraph(); //ini
        jf.add(graph);





    }
}
