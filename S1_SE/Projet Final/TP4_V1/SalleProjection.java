
public class SalleProjection {

  private int nbrPlaceInit;

  private boolean ouvert=false;

  public SalleProjection(int nbPlace){
    this.nbrPlaceInit = nbPlace;
  }

  public int getPlaceInit(){
    return nbrPlaceInit;
  }

  //un client souhaite entrer
  public synchronized void entrer(){
    //Le client attend que la salle ouvre
    if(!ouvert) 
    {
      try{wait();}catch(InterruptedException e){}
    }
    System.out.println(Thread.currentThread().getName() +" est entré dans la salle");
  }
  //un client souhaite sortir
  public synchronized void sortir(){
    if(ouvert){
      //Tant que la sceance est ouverte, les spectateurs ne peuvent pas partir
      //Si la seance est fermé, alors le film est terminé, ils peuvent partir
      try{wait();}catch(InterruptedException e){}
    }
    System.out.println(Thread.currentThread().getName() + ": sors de la salle");
  }
  //La seance commence
  public synchronized void setOuvert()
  {
    ouvert = true;
    System.out.println("\nLa salle ouvre !\n");
    notifyAll();
  }
  //La seance termine
  public synchronized void setFerme()
  {
    ouvert = false;
    System.out.println("\nLa salle ferme !\n");
    notifyAll();
  }
}
