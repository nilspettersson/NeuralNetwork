package testing;

import neural_network.NeuralNetwork;

public class NeuralnetTest1 {

	public static void main(String[] args) {
		NeuralNetwork nn=new NeuralNetwork(1);
		nn.addLayer(1, NeuralNetwork.TANH_FUNCTION);
		//nn.print();
		
		System.out.println("");
		System.out.println(nn.feedForward(new double[] {1})[0]);
		
		for(int i = 0; i < 100; i++) {
			nn.train(new double[] {1}, new double[] {1}, 0.3);
			System.out.println(nn.feedForward(new double[] {1})[0]);
		}
	}

}
