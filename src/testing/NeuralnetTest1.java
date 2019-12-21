package testing;

import neural_network.NeuralNetwork;

public class NeuralnetTest1 {

	public static void main(String[] args) {
		NeuralNetwork nn=new NeuralNetwork(1);
		nn.addLayer(1, 0);
		nn.addLayer(2, 0);
		nn.addLayer(1, 0);
		nn.print();
		
		System.out.println("");
		System.out.println(nn.feedForward(new double[] {1})[0]);
		
	}

}
