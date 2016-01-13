package structs.Pila;
import java.util.Scanner;

public class Pila_Demo{
	
	MyStack pila;
	Scanner read = new Scanner(System.in);

	public Pila_Demo(){
		this.pila=new MyStack(15);
	}

	public Pila_Demo(int capacidad){
		this.pila=new MyStack(capacidad);
	}

	public void mostrarOpciones(){

		 int select = 0;
         String [] options = {"1.-Agregar un elemento a la Pila",
         						"2.-Visualizar el elemento en la cima de la Pila",
         						"3.-Eliminar el elemento en la cima de la Pila",
                            	"4.-Visualizar la pila completa"};

         while(select != -1){//Close when option is breaked

            select = 0;
            System.out.println("\n\t*************[ MENU PRINCIPAL ]****************");

            for(String element:options)
                System.out.println(element);

            try{
                select = read.nextInt();//read option
                switch(select){
                    case 1:
                        agregar();
                        break;
                    case 2:
                        showTop();
                        break;
                    case 3:
                        deleteTop();
                        break;
                    case 4:
                         mostrarPila();
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

	private void agregar(){
		System.out.println("Introduzca la cadena que desea insertar");
		String cadena=read.next();
		pila.push(cadena);
		System.out.println("El tamano de la pila es " + pila.size());
	}
	
	private void mostrarPila(){
		for(int i = pila.size();i>=0;i--){
			String cadena=(String)pila.getPos(i);
			if(i==0) System.out.println(cadena + "       <------------elemento en el fondo de la pila");
			else
				if(i==pila.size()) 
					System.out.println(cadena + "       <------------------elemento en la cima de la pila");
				else
					System.out.println(cadena);
		}

	}

	private void showTop(){
		String cadena=(String)pila.peek();
		System.out.println("La cadena que se encuentra en la cima de la pila es :" + cadena);
	}

	private void deleteTop(){
		String cadena=(String)pila.pop();
		System.out.println("El elemento que ahora se encuentra en la parte superios es: " + cadena);
	}
}