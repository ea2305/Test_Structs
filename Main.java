/**
 *Principal class to initialize structs
 * Test your code in this class
 */

import structs.Pila.*;
import structs.double_list.*;//Uncoment after put one struct in package
import structs.simple_list.*;
import structs.arregloParalelo.*;
import structs.queue.*;
import structs.arbol.*;
import java.util.Scanner;

//Probando GitHub desde Ubuntu

public class Main{

    //Callback
    public static void main(String []argv){

        //Some inputs for test
        String [] input = {"A","B","C","D","E",
                            "F","G","H","I","J",
                            "K","L","M","N","O",
                            "P","Q","R","S","T",
                            "V","W","X","Y","Z"};

        //Implementation and test!
        //in this part only call test_methods

        menu(input);

    }

    /**
     * Struct : Queue
     * put your code here to test this struct
     */
     public static void testQueue()throws Exception{
         System.out.println("\n***** [ PRUEBA DE COLA ] ****\n");
         Queue cola = new Queue();
         System.out.println(">Primer elemento encolado : Primer elemento\n");
         cola.enqueue("Primer elemento");
         System.out.println(">Segundo elemento encolado : Segundo elemento\n");
         cola.enqueue("Segundo elemento");
         System.out.println(">Tercer elemento encolado : Tercer elemento\n");
         cola.enqueue("Tercer elemento");
         
         System.out.println("\n***** vemos el elemento en la proximo a salir ****\n");
         System.out.println("Peek : " + cola.peek());
         
         System.out.println("\n***** quitamos elementos de la cola ****\n");
         
         System.out.println(">Quitamos :  " + cola.dequeue());
         System.out.println(">Quitamos :  " + cola.dequeue());
         System.out.println(">Quitamos :  " + cola.dequeue());
         
     }

     /**
     * Struct : Stack
     * put your code here to test this struct
     */
     public static void testStack(){

	Pila_Demo pila=new Pila_Demo();
	pila.mostrarOpciones();
    }

     public static void testSimple_LinkedList(String [] input){
        ListaSimple<String> lista_simple = new ListaSimple<>();
       
        System.out.println("\n\t***[ PRUEBAS DE LISTA DOBLEMENTE ENLAZADA ]***\n");

        System.out.println("\tContenido sin datos, Incial : " + lista_simple.size() + "\n");
        
        System.out.println(">> Carga de Elemetos a la lista enlazada\n");
        for(String elements: input){
            System.out.print("[" + elements + "] =>");
            lista_simple.add(elements);
        }
        
        System.out.println("\n\n\tContenido con datos cargados, Final: " + lista_simple.size());;


        //add in position
        System.out.println("\n***Agregamos elemento en la segunda posicion");
        lista_simple.addPos(2,"Elemento agregado <- en posicion 2");
        lista_simple.listUp();
        

        //remove in position
        System.out.println("\n***Removemos elemento en la segunda posicion");
        lista_simple.remove(2);
        lista_simple.listUp();
     
        //Search test
        System.out.println("\nPrueba de busqueda de elementos en la lista");
        System.out.print("\n>Busqueda del 8vo elemento  : " + lista_simple.get(8).getData());
        System.out.print("\n>Busqueda del 10mo elemento : " + lista_simple.get(10).getData());
        System.out.print("\n>Busqueda del 3vo elemento  : " + lista_simple.get(3).getData() + "\n\n");
     }

     /**
     * Struct : Doble linked list
     * put your code here to test this struct
     */

     public static void testDouble_LinkedList(String[] input){

        //Implementation of struct
        Doble_LinkedList<String> Linked_List  = new Doble_LinkedList<>();

        //add test
        System.out.println("\n\t***[ PRUEBAS DE LISTA DOBLEMENTE ENLAZADA ]***\n");

        System.out.println("\tContenido sin datos, Incial : " + Linked_List.size() + "\n");

        //Load elements in linked list
        System.out.println(">> Carga de Elemetos a la lista enlazada\n");
        for(String elements: input){
            System.out.print("[" + elements + "]<=>");
            Linked_List.add(elements);
        }

        System.out.println("\n\n\tContenido con datos cargados, Final: " + Linked_List.size());;

        //Check elements until last element
        System.out.println("\n\n***Recorrido de datos de manera ascendente, del primer nodo al ultimo");
        Linked_List.listUp();

        //Check elements until last element
        System.out.println("\n\n***Recorrido de datos de manera descendente, del ultimo nodo al primero");
        Linked_List.listDown();

        //add in position
        System.out.println("\n***Agregamos elemento en la segunda posicion");
        Linked_List.addPos(2,"Elemento agregado <- en posicion 2");
        Linked_List.listUp();

        //remove in position
        System.out.println("\n***Removemos elemento en la segunda posicion");
        Linked_List.remove(2);
        Linked_List.listUp();

        //Search test
        System.out.println("\nPrueba de busqueda de elementos en la lista");
        System.out.print("\n>Busqueda del 8vo elemento  : " + Linked_List.get(8).getData());
        System.out.print("\n>Busqueda del 10mo elemento : " + Linked_List.get(10).getData());
        System.out.print("\n>Busqueda del 3vo elemento  : " + Linked_List.get(3).getData() + "\n\n");

     }

     /**
     * Struct : Parallel Array
     * put your code here to test this struct
     */

    public static void testParallelArray(){
      ArregloParalelo ap = new ArregloParalelo(10);
      ap.visualizar();
    }

    private static void creditos(){
        System.out.println("\n\n");
        System.out.println("...Universidad Politecnica de Chiapas...");
        System.out.println("......Estructura de Datos Avanzada......");
        System.out.println("-------------Integrantes----------------\n");
        System.out.println("Carlos Maximiliano Ortiz Escobar 143406");
        System.out.println("Elihu Alejandro Cruz Albores 143403");
        System.out.println("Luis Angel Farelo Toledo 143404");
        System.out.println("Luis Antonio Alcocer Dominguez 143513");
        System.out.println("Julio de Buen Hernandez 143460");
    }

    /**
     * Struct : Binary Tree
     * put your code here to test this struct
     */
     public static void testBinaryTree(){
       ArbolPrueba.iniciar();
     }

     public static void menu(String[] input){

         //strucst for options
         int select = 0;
         Scanner read = new Scanner(System.in);
         String [] options = {"1.-Cola","2.-Pila","3.-Lista Simple",
                              "4.-Lista Doblemente Enlazada","5.-Arreglo Paralelo",
                              "6.-Arbol Binario",
                              "7.- Creditos","[8...10).-Salir"};

         while(select != -1){//Close when option is breaked

            select = 0;
            System.out.println("\n\t*************[ MENU PRINCIPAL ]****************");

            for(String element:options)
                System.out.println(element);

            try{
                select = read.nextInt();//read option
                switch(select){
                    case 1:
                        testQueue();
                        break;
                    case 2:
                        testStack();
                        break;
                    case 3:
                        testSimple_LinkedList(input);
                        break;
                    case 4:
                        testDouble_LinkedList(input);
                        break;
                    case 5:
                        testParallelArray();
                        break;
                    case 6:
                        testBinaryTree();
                        break;
                    case 7:
                        creditos();
                        break;
                    default:
                        select = -1;
                        break;
                }
            }catch(Exception e){//if input isn't integer
                System.out.println("\n\tImportante! -> Introduzca solo numeros\n");
                read = new Scanner(System.in);//restart reader
            }

         }

     }

}
