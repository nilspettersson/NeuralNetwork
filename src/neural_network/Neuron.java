package neural_network;

import java.util.ArrayList;

public class Neuron {
	
	private double value;
	private int activation;
	
	private ArrayList<Double>weights=new ArrayList<Double>();
	private double bias;
	
	public Neuron(int inputSize,int activation) {
		bias=Math.random();
		this.activation=activation;
		for(int i=0;i<inputSize;i++) {
			weights.add(Math.random());
		}
	}
	
	
	public void calculateOutput(double values[]) {
		if(activation==0) {
			for(int i=0;i<values.length;i++) {
				value+=values[i]*weights.get(i);
			}
			value+=bias;
		}
	}
	
	
	public void print() {
		System.out.println("value: "+value);
		if(activation==0) {
			System.out.println("activation: "+"no activation");
		}
		
		System.out.println("bias: "+bias);
		System.out.println("WEIGHTS");
		for(int i=0;i<weights.size();i++) {
			System.out.println("weight"+i+": "+weights.get(i));
		}
		System.out.println("");
	}
	

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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
	
	
	
}
