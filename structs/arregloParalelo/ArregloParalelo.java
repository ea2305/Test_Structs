package structs.arregloParalelo;

public class ArregloParalelo{

  public final String[] listaNombres = {
      "Luis","Angel","Farelo","Toledo","Flyzx",
      "Anna","Blanca","Cecilia","Domelza","Eleonor"
    };

  public int num;
  public String[] nombre;
  public int[] edad;
  public char[] sexo;

  public ArregloParalelo(int num){
    this.num = num;
    this.nombre = new String[num];
    this.edad = new int[num];
    this.sexo = new char[num];
    inicializar();
  }

  public void visualizar(){
    for (int i=0; i<this.num; i++) {
      System.out.print("\t"+i);
      System.out.print("\t"+this.nombre[i]);
      System.out.print("\t"+this.edad[i]);
      System.out.println("\t"+this.sexo[i]);
    }
    System.out.println("\n\n");
    for (int j=0; j<3 ; j++ ) {
      int a = getPosRandom();
      System.out.print("Usuario\t"+a);
      System.out.print("\t"+this.nombre[a]);
      System.out.print("\t"+this.edad[a]);
      System.out.println("\t"+this.sexo[a]);
    }
    System.out.println("\n\n");
  }

  public void inicializar(){
    for (int i=0; i<this.num; i++) {
      this.nombre[i] = getNombreRandom();
      this.edad[i] = getEdadeRandom();
      this.sexo[i] = getSexoRandom();
    }
  }

  public int getPosRandom(){
    return (int )(Math.random() * this.listaNombres.length);
  }

  public String getNombreRandom(){
    return this.listaNombres[getPosRandom()];
  }
  public int getEdadeRandom(){
    return (int )(Math.random() * 75 + 1);
  }
  public char getSexoRandom(){
    if(Math.random() < .5)
      return 'M';
    return 'F';
  }
}
