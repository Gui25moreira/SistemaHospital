package model.atendimento;

import java.util.concurrent.TimeUnit;

public class Cirurgia {

    public static void realizarCirurgia() throws InterruptedException {
        System.out.println("Realizando cirurgia...");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Cirurgia realizada");
    }

}
