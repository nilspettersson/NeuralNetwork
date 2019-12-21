package testing;

import neural_network.Neuron;

public class NeuronTest {

	public static void main(String[] args) {
		Neuron n=new Neuron(1,0);
		n.calculateOutput(new double[] {1});
		n.print();
	}

}
