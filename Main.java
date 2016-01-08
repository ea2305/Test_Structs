/**
 *Principal class to initialize structs
 * Test your code in this class
 */

import structs.double_list.*;//Uncoment after put one struct in package

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
        
        testQueue();//Add parameters if you need any
        
        testStack();//Add parameters if you need any
         
        testSimple_LinkedList();//Add parameters if you need any
         
        testDouble_LinkedList();//Add parameters if you need any
         
        testParallelArray();//Add parameters if you need any
         
        testBinaryTree();//Add parameters if you need any  
        
    }
    
    /**
     * Struct : Queue
     * put your code here to test this struct
     */
     public static void testQueue(){}
     
     /**
     * Struct : Stack
     * put your code here to test this struct
     */
     public static void testStack(){}
     
     /**
     * Struct : Simple Linked List
     * put your code here to test this struct
     */
     public static void testSimple_LinkedList(){}
     
     /**
     * Struct : Doble linked list
     * put your code here to test this struct
     */
     
     public static void testDouble_LinkedList(String[] input){
         
         //Implementation of struct
         Doble_LinkedList<String> Linked_List  = new Doble_LinkedList<>();
         
         System.out.println("\n***Pruebas para Lista doblemente enlazada***\n");
         
         System.out.println("\tContenido sin datos, Incial : " + Linked_List.size() + "\n");
         
         System.out.println(">> Carga de Elemetos a la lista enlazada\n");
         for(String elements: input){
             System.out.print("[" + elements + "]<=>");
             Linked_List.add(elements);
         }
         
         System.out.println("\n\n\tContenido con datos cargados, Final: " + Linked_List.size());;
     }
     
     /**
     * Struct : Parallel Array
     * put your code here to test this struct
     */
    
    public static void testParallelArray(){}
    
    /**
     * Struct : Binary Tree
     * put your code here to test this struct
     */
     
     public static void testBinaryTree(){}
         
}