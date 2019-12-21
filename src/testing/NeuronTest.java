package testing;

import neural_network.Neuron;

public class NeuronTest {

	public static void main(String[] args) {
		Neuron n=new Neuron(2,0);
		for(int i=0;i<100000;i++) {
			n.train(new double[] {1,1}, 1, 0.04);
			n.train(new double[] {0,1}, 1, 0.04);
			n.train(new double[] {1,0}, 1, 0.04);
			n.train(new double[] {0,0}, 0, 0.04);
			System.out.println(n.calculateOutput(new double[] {1,1}));
		}
		System.out.println("");
		System.out.println(n.calculateOutput(new double[] {1,1}));
		System.out.println(n.calculateOutput(new double[] {0,1}));
		System.out.println(n.calculateOutput(new double[] {1,0}));
		System.out.println(n.calculateOutput(new double[] {0,0}));
	}

}
