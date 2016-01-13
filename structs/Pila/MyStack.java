package structs.Pila;

public class MyStack
{
	private Object pila[];
	private int tope;

	public MyStack(int capacidad)
	{
		pila=new Object[capacidad];
		tope = -1;
	}

	public boolean isEmpty()
	{
		return tope ==-1;
	}

	public void push(Object i)
	{
		if(tope+1 < pila.length)
			pila[++tope]=i;
	}
	public Object pop()
	{
		if(isEmpty())
			return 0;
		return pila[tope--];
	}

	public Object peek()
	{
		if(isEmpty())
			return "0";
		return pila[tope];
	}
//Metodos ajenos de la estructura esencial de una  Pila para fines ilustrativos
	public int size(){
		return tope;
	}

	public Object getPos(int pos){
		return this.pila[pos];
	}

}

	

