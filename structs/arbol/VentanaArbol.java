package structs.arbol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class VentanaArbol extends JFrame{

  private JLabel misDatos, numNodos, altura;
  private JPanel datos;
  private TestPane tp;
  private Arbol<String> arbol;

  public VentanaArbol(Arbol<String> arbol){
    super();
    this.arbol = arbol;
    configurarVentana();
    inicializarComponentes();
  }

  private void configurarVentana(){
    this.setTitle("Arbol");
    this.setSize(1200, 700);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
  }

  private void inicializarComponentes(){
    misDatos = new JLabel(" Luis Angel Farelo Toledo 143404 ");
    numNodos = new JLabel(" Numero de nodos: "+arbol.getRaiz().getNumNodos()+" ");
    altura = new JLabel(" Altura del arbol: "+arbol.getRaiz().getAltua()+" ");

    datos = new JPanel(new BorderLayout());
    datos.add(misDatos, BorderLayout.NORTH);
    datos.add(numNodos, BorderLayout.WEST);
    datos.add(altura, BorderLayout.EAST);
    this.add(datos, BorderLayout.NORTH);
    tp = new TestPane();
    this.add(tp, BorderLayout.CENTER);
  }

  public class TestPane extends JPanel {

    private Arbol<String> inicializar(){
        Arbol<String> arbol = new Arbol<String>();
        arbol.insertar("Es privado");
        Node<String> nodo = arbol.getRaiz();
        nodo.setPrevious(new Node<String>("Carro"));
        nodo.setNext(new Node<String>("Autobus"));
        return arbol;
    }

    private Arbol<String> leerArbol() {
        Arbol<String> arbol;
        try {
            final FileInputStream fis = new FileInputStream("datos.bin");
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object deserializedObject = ois.readObject();
            if (deserializedObject instanceof Arbol) {
                arbol = (Arbol<String>) deserializedObject;
            } else {
                arbol = inicializar();
            }
            ois.close();
        } catch (Exception e) {
            arbol = inicializar();
        }
        return arbol;
    }

    public void dibujar(Arbol<String> arbol, Graphics g){
      Node<String> nodo = arbol.getRaiz();
      int x = 550;
      int y = 30;
      int yi = y+30;
      if(nodo != null)
        g.fillOval(x-7, y-7, 14, 14);
      if(nodo.getPrevious() != null){
        int xi = x/2;
        g.drawLine (x, y, xi, yi);
        dibujar(nodo.getPrevious(), xi, yi, x, g);
      }

      if(nodo.getNext() != null){
        int xi = 3*(x/2);
        g.drawLine (x, y, xi, yi);
        dibujar(nodo.getNext(), xi, yi, x, g);
      }

    }

    private void dibujar(Node<String> nodo, int x, int y, int oldX, Graphics g){
      int yi = y+50;
      if(nodo != null)
        g.fillOval(x-7, y-7, 14, 14);
      if(nodo.getPrevious() != null){
        int xi = oldX - x;
        xi = xi/2;
        xi = oldX - xi;
        g.drawLine (x, y, xi, yi);
        dibujar(nodo.getPrevious(), xi, yi, x, g);
      }

      if(nodo.getNext() != null){
        int xi = oldX - x;
        xi = 3*(xi/2);
        xi = oldX -xi;
        g.drawLine (x, y, xi, yi);
        dibujar(nodo.getNext(), xi, yi, x, g);
      }

    }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1100, 700);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Arbol<String> arbol = leerArbol();
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            dibujar(arbol, g);
        }
    }

}
