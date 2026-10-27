import java.util.LinkedList;

public class Controlador {
    static boolean listo=false;

    synchronized void esperar() throws InterruptedException {
      wait();
    }
    synchronized  void  desesperar(){
        notifyAll();
    }




}
