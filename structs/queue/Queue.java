package structs.queue;
/**
*@version 1.2
*/
public class Queue {

	public static final int DEFAULT_SIZE=5;
	private int Top = 1;
	private Object data[];
	private int index = 0;

	/**
	*Metodo constructor
	*/
	public Queue(){
		data = new Object[DEFAULT_SIZE];
		this.Top = DEFAULT_SIZE;
	}

	/**
	*Metodo constructor con dimension espesifica
	*@param variable s : entera determina el tamaño de la cola
	*/
	public Queue(int s){
		data = new Object[s];
		this.Top = s;
	}

	/**
	*Verifica si la cola esta vacia
	*@return index : booleano 
	*/
	public boolean isEmpty(){
		return index == 0;
	}

	/**
	*@param obj : Object para carga de datos
	*
	*/
	public void enqueue(Object obj) throws Exception{
		
		if(index == Top)throw new Exception("Queue is full. Dequeue some objects");

		this.data[index++]= obj;
	}

	/**
	*Sacar valor de la cola
	*@return obj : Object con valor en la primer posicion
	*/
	public Object dequeue() throws Exception{

		if(isEmpty())
			throw new Exception("Queue is empty");

		Object obj = this.data[0];

		for(int i = 0; i< this.index-1 ; i++){
			data[i] = data[i+1];
		}	

		this.index--;
		return obj;
	}

	/**
	*Metodo para captura de valor a salida
	*@param data : Object deuelve el valor proximo a salir
	*/
	public Object peek() throws Exception{

		if(isEmpty())
			throw new Exception("Queue is empty");

		return this.data[0];
	}

	/**
	*Numero de elementos en la cola
	*@return index : entero , index
	*/
	public int size(){return this.index;}

}