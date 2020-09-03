package neural_network;

import java.util.ArrayList;

public class NeuralNetwork {
	public static final int STEP_FUNCTION=1;
	public static final int RELU_FUNCTION=2;
	public static final int TANH_FUNCTION=3;
	
	private int inputSize;
	
	private ArrayList<Layer>layers=new ArrayList<>();
	
	public NeuralNetwork(int inputSize) {
		this.inputSize=inputSize;
	}
	
	
	public NeuralNetwork copy() {
		NeuralNetwork nnCopy=new NeuralNetwork(this.getInputSize());
		for(int i=0;i<layers.size();i++) {
			nnCopy.addLayer(layers.get(i).getNeurons().size(), layers.get(i).getActivation());
			for(int ii=0;ii<layers.get(i).getNeurons().size();ii++) {
				for(int iii=0;iii<layers.get(i).getNeurons().get(ii).getWeights().size();iii++) {
					nnCopy.getLayers().get(i).getNeurons().get(ii).getWeights().set(iii, getLayers().get(i).getNeurons().get(ii).getWeights().get(iii));
				}
				nnCopy.getLayers().get(i).getNeurons().get(ii).setBias(getLayers().get(i).getNeurons().get(ii).getBias());
			}
		}
		return nnCopy;
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
	
	public void train(double inputs[], double labels[], double learningRate) {
		double outputs[] = feedForward(inputs);
		double errors[] = new double[labels.length];
		for(int i = 0; i < errors.length; i++) {
			errors[i] = labels[i] - outputs[i];
		}
		
		for(int i = layers.size() - 1; i >= 0; i--) {
			if(i == layers.size() - 1) {
				for(int ii = 0; ii < layers.get(i).getNeurons().size(); ii++) {
					if(i > 0) {
						layers.get(i).getNeurons().get(ii).backpropagation(layers.get(i - 1), errors[ii], learningRate);
					}
					else {
						layers.get(i).getNeurons().get(ii).backpropagation(inputs, errors[ii], learningRate);
					}
					
				}
			}
		}
		
	}

	
	
	public void mutate(double amount) {
		for(int i=0;i<layers.size();i++) {
			for(int ii=0;ii<layers.get(i).getNeurons().size();ii++) {
				for(int iii=0;iii<layers.get(i).getNeurons().get(ii).getWeights().size();iii++) {
					layers.get(i).getNeurons().get(ii).getWeights().set(iii, layers.get(i).getNeurons().get(ii).getWeights().get(iii)+(Math.random()*amount)-amount/2);
				}
			}
		}
	}
	
	
	public void print() {
		System.out.println("outputs size: " + layers.get(layers.size() - 1).getNeurons().size());
		for(int i = 0;  i < layers.size(); i++) {
			System.out.println("Layer " + i + "  Neuron count: " + layers.get(i).getNeurons().size());
			for(int ii = 0;ii < layers.get(i).getNeurons().size(); ii++) {
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
