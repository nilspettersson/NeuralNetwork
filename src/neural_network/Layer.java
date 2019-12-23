package neural_network;

import java.util.ArrayList;

public class Layer {
	
	private ArrayList<Neuron>neurons=new ArrayList<>();
	
	private int activation;
	public Layer(int size, int activation,int inputSize) {
		this.activation=activation;
		for(int i=0;i<size;i++) {
			neurons.add(new Neuron(inputSize, activation));
		}
	}
	

	public ArrayList<Neuron> getNeurons() {
		return neurons;
	}

	public void setNeurons(ArrayList<Neuron> neurons) {
		this.neurons = neurons;
	}

	public int getActivation() {
		return activation;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}
	
	
	

}
