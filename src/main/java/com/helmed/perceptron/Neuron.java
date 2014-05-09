/**
 * 
 */
package com.helmed.perceptron;

/**
 * Makes predictions based on a linear predictor function combining a set of weights with the feature vector.
 * @author helmed
 */
public class Neuron {
	
	private static final double LEARNING_RATE = 0.01;
	private double weight1;
	private double weight2;
	private double weight3;


	/** DEFAULT CONSTRUCTOR	 */
	public Neuron() {
		weight1 = Math.random();
		weight2 = Math.random();
		weight3 = Math.random();
	}
	
	public double inputs(double fistInput, double secondInput){
        double output;

		double tmp1 = fistInput * weight1;
		double tmp2 = secondInput * weight2;
		double tmp3 = 1 * weight3;

        output = stepActivationFunction(tmp1 + tmp2 + tmp3);

        return output;
	}
	
	

	/**
     * Modelling feature "all-or-nothing"
	 * @param input - The value to be analyzed.
	 * @return the output will be equal to 0 if the activation value is negative and 1 where the value of activation is positive.
	 */
	private int stepActivationFunction(double input) {
        int output = 1;

        if(input < 0.0) output = 0;

        return output;
	}

	/**
	 *
	 */
	public void training(double[] x1, double[] x2, double[] d) {
		for (int i = 0; i < x1.length; i++) {
			
			double saida = inputs(x1[i], x2[i]);
			
			int erro = (int)(d[i] - saida);
			
			adjustWeitghts(x1, x2, i, erro);
			
			System.out.println(" weight1 -> " + weight1 + " weight2 -> " + weight2 + " weight3 -> " + weight3);
		}
		
	}

	/**
	 * @param x1
	 * @param x2
	 * @param i
	 * @param erro
	 */
	private void adjustWeitghts(double[] x1, double[] x2, int i, int erro) {
		weight1 = weight1 + LEARNING_RATE * erro * x1[i];
		weight2 = weight2 + LEARNING_RATE * erro * x2[i];
		weight3 = weight3 + LEARNING_RATE * erro * 1;
	}

}
