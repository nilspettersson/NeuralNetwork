package neural_network;

import java.util.ArrayList;

public class Neuron {
	private double value=0;
	private int activation;
	
	private ArrayList<Double>weights=new ArrayList<Double>();
	private double bias;
	
	public Neuron(int inputSize,int activation) {
		bias=(Math.random()*2)-1;
		this.activation=activation;
		for(int i=0;i<inputSize;i++) {
			weights.add((Math.random()*2)-1);
		}
	}
	
	
	public double calculateOutput(double inputs[]) {
		double output=0;
		for(int i=0;i<inputs.length;i++) {
			if(activation == NeuralNetwork.LOG_FUNCTION) {
				output += Math.log(inputs[i] * weights.get(i));
			}
			else {
				output += inputs[i] * weights.get(i);
			}
		}
		output += bias;
		
		if(activation == NeuralNetwork.STEP_FUNCTION) {
			if(output >= 0.5) {
				output = 1;
			}
			else {
				output = 0;
			}
		}
		else if(activation == NeuralNetwork.RELU_FUNCTION) {
			if(output <= 0) {
				output = 0;
			}
		}
		else if(activation == NeuralNetwork.TANH_FUNCTION) {
			output=Math.tanh(output);
		}
		else if(activation == NeuralNetwork.LOG_FUNCTION) {
			output = Math.exp(output);
		}
		
		value = output;
		return output;
	}
	
	public double calculateOutput(ArrayList<Neuron>inputs) {
		double output=0;
		for(int i = 0;i < inputs.size(); i++) {
			if(activation == NeuralNetwork.LOG_FUNCTION) {
				output += Math.log(inputs.get(i).value * weights.get(i));
			}
			else {
				output += inputs.get(i).value * weights.get(i);
			}
		}
		output += bias;
		
		if(activation == NeuralNetwork.STEP_FUNCTION) {
			if(output >= 0.5) {
				output = 1;
			}
			else {
				output = 0;
			}
		}
		else if(activation == NeuralNetwork.RELU_FUNCTION) {
			if(output <= 0) {
				output  =0;
			}
		}
		else if(activation == NeuralNetwork.TANH_FUNCTION) {
			output=Math.tanh(output);
		}
		else if(activation == NeuralNetwork.LOG_FUNCTION) {
			output=Math.exp(output);
		}
		value = output;
		return output;
	}
	
	public void train(double inputs[],double label,double learningRate) {
		double output = calculateOutput(inputs);
		double error = label - output;
		for(int i = 0;i < inputs.length; i++) {
			weights.set(i, weights.get(i) + (error * inputs[i] * learningRate));
		}
		bias = bias + error * learningRate;
	}
	
	public void backpropagation(double inputs[],double error,double learningRate) {
		double output = calculateOutput(inputs);
		for(int i = 0;i < inputs.length; i++) {
			weights.set(i, weights.get(i) + (error * inputs[i] * learningRate));
		}
		bias = bias + error * learningRate;
	}
	
	//the layer parameter should be the input layer of the current neuron.
	public void backpropagation(Layer layer, double error, double learningRate) {
		double output = calculateOutput(layer.getNeurons());
		for(int i = 0;i < layer.getNeurons().size(); i++) {
			weights.set(i, weights.get(i) + (error * layer.getNeurons().get(i).getValue() * learningRate));
		}
		bias = bias + error * learningRate;
	}
	
	
	public double getWeightSum() {
		double sum = 0;
		for(int i = 0; i < weights.size(); i++) {
			sum += weights.get(i);
		}
		return sum;
	}
	
	
	public void print() {
		if(activation==0) {
			System.out.println("activation: " + "no activation");
		}
		if(activation==NeuralNetwork.STEP_FUNCTION) {
			System.out.println("activation: " + "STEP_FUNCTION");
		}
		
		System.out.println("bias: "+bias);
		System.out.println("WEIGHTS");
		for(int i = 0;i < weights.size(); i++) {
			System.out.println("weight" + i + ": " + weights.get(i));
		}
		System.out.println("");
	}
	


	public int getActivation() {
		return activation;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}

	public ArrayList<Double> getWeights() {
		return weights;
	}

	public void setWeights(ArrayList<Double> weights) {
		this.weights = weights;
	}

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
