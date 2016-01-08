/**
 *Principal class to initialize structs
 * Test your code in this class
 */

import structs.double_list.*;//Uncoment after put one struct in package

public class Main{

    //Callback
    public static void main(String []argv){
        
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
     
     public static void testDouble_LinkedList(){
         
         //Implementation of struct
         Doble_LinkedList<String> A  = new Doble_LinkedList<>();
         String [] input = {"Cadena_1","Cadena_2","Cadena_3","Cadena_4","Cadena_5",
                            "Cadena_6","Cadena_7","Cadena_8","Cadena_9","Cadena_10",
                            "Cadena_11","Cadena_12","Cadena_14","Cadena_15","Cadena_16"};
         
         System.out.println("Contenido sin datos, incial : " + A.size());
         A.add("Hola");
         System.out.println("Contenido con datos: " + A.size());;
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