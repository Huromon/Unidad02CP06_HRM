import java.util.Formattable;
import java.util.LinkedList;
import java.util.Random;

public class CalcularFibonacci implements Runnable {
    private final LinkedList<FibonaziHebra> hilos ;
    Controlador controlador;

    CalcularFibonacci( Controlador controlador) {
        this.controlador = controlador;
        hilos = new  LinkedList<FibonaziHebra>();
    }
    synchronized public void añadirHebra(FibonaziHebra hebra) {
        hilos.add(hebra);
    }
    synchronized public void quitarHebra() {
        hilos.removeFirst();
    }


    @Override
    public void run() {
        Integer ll = 2;
        Integer re=0;
        System.out.println("'hilo 1' = 0");
        System.out.println("'hilo 2' = 1");
        for (int k = 0; k < hilos.size(); k++) {

            System.out.println("hilo nº "+ll);
            re=hilos.get(k).calcular();
            controlador.desesperar();
            ll++;
            if (k==hilos.size()-1) {
                System.out.println("numero "+FibonaziHebra.numeroFibonacci+" de Fibonacci es el "+re);
            }
        }


    }





}
