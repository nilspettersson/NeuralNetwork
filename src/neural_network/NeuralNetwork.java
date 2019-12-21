package neural_network;

import java.util.ArrayList;

public class NeuralNetwork {
	private int inputSize;
	
	private ArrayList<Layer>layers=new ArrayList<>();
	
	public NeuralNetwork(int inputSize) {
		this.inputSize=inputSize;
	}
	
	public void addLayer(int size, int activation) {
		if(layers.size()==0) {
			layers.add(new Layer(size, activation, inputSize));
		}
		else {
			layers.add(new Layer(size, activation, layers.get(layers.size()-1).getNeurons().size()));
		}
	}
	
	public double[] feedForward(double inputs[]) {
		double output[]=new double[layers.get(layers.size()-1).getNeurons().size()];
		for(int i=0;i<layers.size();i++) {
			for(int ii=0;ii<layers.get(i).getNeurons().size();ii++) {
				if(i==0) {
					layers.get(i).getNeurons().get(ii).calculateOutput(inputs);
				}
				else {
					layers.get(i).getNeurons().get(ii).calculateOutput(layers.get(i-1).getNeurons());
				}
			}
		}
		
		for(int i=0;i<layers.get(layers.size()-1).getNeurons().size();i++) {
			output[i]=layers.get(layers.size()-1).getNeurons().get(i).getValue();
		}
		return output;
		
	}
	
	public void print() {
		System.out.println("outputs size: "+layers.get(layers.size()-1).getNeurons().size());
		for(int i=0;i<layers.size();i++) {
			System.out.println("layer "+i+" size: "+layers.get(i).getNeurons().size());
			for(int ii=0;ii<layers.get(i).getNeurons().size();ii++) {
				layers.get(i).getNeurons().get(ii).print();
			}
			System.out.println("");
		}
	}
	
	
	

	public int getInputSize() {
		return inputSize;
	}

	public void setInputSize(int inputSize) {
		this.inputSize = inputSize;
	}

	public ArrayList<Layer> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}
	
	

}
