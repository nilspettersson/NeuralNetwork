package testing;

import java.util.Scanner;

import neural_network.NeuralNetwork;

public class NeuralnetTest1 {

	public static void main(String[] args) {
		NeuralNetwork nn=new NeuralNetwork(2);
		nn.addLayer(1, NeuralNetwork.LOG_FUNCTION);
		nn.setWeights(0, 0);
		nn.print();

		
		double lr = 0.01;
		for(int i = 0; i < 10; i++) {
			nn.train(new double[] {1, 2}, new double[] {2}, lr);
			nn.train(new double[] {2, 3}, new double[] {6}, lr);
			nn.train(new double[] {3, 4}, new double[] {12}, lr);
			nn.train(new double[] {4, 5}, new double[] {20}, lr);
			
			System.out.println(nn.feedForward(new double[] {1, 1})[0]);
		}
		System.out.println("");
		
		Scanner input = new Scanner(System.in);
		while(true) {
			int x = input.nextInt();
			int y = input.nextInt();
			System.out.println(nn.feedForward(new double[] {x, y})[0]);
		}
	}

}
