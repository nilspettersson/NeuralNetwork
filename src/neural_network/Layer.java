package neural_network;

import java.util.ArrayList;

public class Layer {
	
	private ArrayList<Neuron>neurons=new ArrayList<>();
	
	public Layer(int size, int activation,int inputSize) {
		for(int i=0;i<size;i++) {
			neurons.add(new Neuron(inputSize, activation));
		}
	}
	
	/*public double[] toArray() {
		double[] array=new double[neurons.size()];
		for(int i=0;i<neurons.size();i++) {
			array[i]=neurons.get(i).
		}
	}*/
	

	public ArrayList<Neuron> getNeurons() {
		return neurons;
	}

	public void setNeurons(ArrayList<Neuron> neurons) {
		this.neurons = neurons;
	}
	
	
	

}
