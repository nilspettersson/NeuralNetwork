package testing;

import neural_network.NeuralNetwork;

public class NeuralnetTest1 {

	public static void main(String[] args) {
		NeuralNetwork nn=new NeuralNetwork(2);
		nn.addLayer(8, NeuralNetwork.RELU_FUNCTION);
		nn.addLayer(1, NeuralNetwork.STEP_FUNCTION);
		//nn.print();
		
		System.out.println("");
		System.out.println(nn.feedForward(new double[] {1})[0]);
		
		double lr = 0.01;
		for(int i = 0; i < 10000; i++) {
			nn.train(new double[] {1, 1}, new double[] {0}, lr);
			nn.train(new double[] {1, 0}, new double[] {1}, lr);
			nn.train(new double[] {0, 1}, new double[] {1}, lr);
			nn.train(new double[] {0, 0}, new double[] {0}, lr);
			System.out.println(nn.feedForward(new double[] {1, 1})[0]);
		}
		System.out.println("");
		System.out.println(nn.feedForward(new double[] {1, 1})[0]);
		System.out.println(nn.feedForward(new double[] {1, 0})[0]);
		System.out.println(nn.feedForward(new double[] {0, 1})[0]);
		System.out.println(nn.feedForward(new double[] {0, 0})[0]);
	}

}
