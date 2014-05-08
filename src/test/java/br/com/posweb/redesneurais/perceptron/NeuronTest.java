package br.com.posweb.redesneurais.perceptron;

import org.junit.Test;

/**
 * .
 * User: helmedeiros
 * Date: 5/7/14
 * Time: 11:30 PM
 */
public class NeuronTest {

    @Test public void test() {

        Neuron n = new Neuron();

        double[] x1 = {1,2,1,2,1,4,4,5,5,5};
        double[] x2 = {1,1,2,2,3,4,5,3,4,5};
        double[] d =  {0,0,0,0,0,1,1,1,1,1};

        //epoca de treinamento
        for (int i = 0; i < 100; i++) {
            n.training(x1, x2, d, "sigmoid");
        }

        double saida = n.inputs(1, 1);
        System.out.println("(1,1) " + saida);
        saida = n.inputs(0, 0);
        System.out.println("(0,0) " + saida);
        saida = n.inputs(6, 6);
        System.out.println("(6,6) " + saida);
        saida = n.inputs(2, 5);
        System.out.println("(2,5) " + saida);
        saida = n.inputs(5, 2);
        System.out.println("(5,2) " + saida);

    }

    @Test public void test2() throws Exception {

            double[] x1 = {0,0,1,1};
            double[] x2 = {0,1,0,1};
            double[] d =  {0,0,0,1};

            Neuron n = new Neuron();

            //epoca de treinamento
            for (int i = 0; i < 10; i++) {
                n.training(x1, x2, d, "sigmoid");
            }

            double saida = n.inputs(0, 0);
            System.out.println("(0,0) " + saida);
            saida = n.inputs(0, 1);
            System.out.println("(0,1) " + saida);
            saida = n.inputs(1, 0);
            System.out.println("(1,0) " + saida);
            saida = n.inputs(1, 1);
            System.out.println("(1,1) " + saida);

    }
}
