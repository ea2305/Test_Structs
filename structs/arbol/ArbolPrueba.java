/**
 * laft.flyzx@gmail.com
 * @author Luis Angel Farelo Toledo Adivina mi transporte
 */
package structs.arbol;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ArbolPrueba{

    private static Arbol<String> arbol;
    private static VentanaArbol va;
    private static final String repetir = ("\n" + "volver a jugar ");
    private static final String pedir = ("\n"
            + "Escribe el numero que pensaste: ");

    private static String pedirPregunta(String option1, String option2) {

        return Read.line("\n"
                + "Escribe una afirmación que sea verdad para un (una) "
                + option1 + "\n" + "pero que sea falsa para un (una) "
                + option2 + "\n" + ": "
        );
    }

    private static char pregunta(String pregunta) {
        return Read.character("\n" + pregunta + "? (s/n): ");
    }

    private static void jugar(char option) {
        arbol = leerArbol();
        Node<String> nodo = arbol.getRaiz();
        if (option == 's') {
            preguntar(nodo);
            guardarArbol(arbol);
        }
        if (option != 'n') {
            jugar(pregunta(repetir));
        }
    }

    private static void preguntar(Node<String> nodo) {
        char res = pregunta(nodo.getData());
        if (res == 's') {
            if (nodo.getPrevious() != null) {
                preguntar(nodo.getPrevious());
            } else {
                respuesta('s', nodo);
            }
        } else if (res == 'n') {
            if (nodo.getNext() != null) {
                preguntar(nodo.getNext());
            } else {
                respuesta('n', nodo);
            }
        } else if (res == 'd'){
          va = new VentanaArbol(arbol);
          va.setVisible(true);
          preguntar(nodo);
        } else {
            preguntar(nodo);
        }
    }

    private static void respuesta(char option, Node<String> nodo) {
        if (option == 's') {
            System.out.println("Gracias por jugar");
        } else if (option == 'n') {
          String r1 ="es el " + Read.line(pedir);
          String r2 = nodo.getData();

          if(r1.compareTo(r2) < 0){
            String pre = r1.remplaceAll("es el","es menor igual que el");
            nodo.setData(pre);
            nodo.setPrevious(new Node<String>(r1));
            nodo.setNext(new Node<String>(r2));
          }else{
            String pre = r2.remplaceAll("es el","es menor igual que el");
            nodo.setData(pre);
            nodo.setPrevious(new Node<String>(r2));
            nodo.setNext(new Node<String>(r1));
          }
        } else {
            respuesta(option, nodo);
        }
    }

    private static Arbol<String> inicializar(){
        Arbol<String> arbol = new Arbol<String>();
        arbol.insertar("es menor igual que el 5");
        Node<String> nodo = arbol.getRaiz();
        nodo.setPrevious(new Node<String>("es el 2"));
        nodo.setNext(new Node<String>("es el 7"));
        return arbol;
    }

    private static Arbol<String> leerArbol() {
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

    private static void guardarArbol(Arbol<String> arbol) {
        try {
            final FileOutputStream fo = new FileOutputStream("datos.bin");
            final ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(arbol);
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        System.out.println("\t *Piense en un medio de transporte");
        jugar('s');
    }

}
