package neural_network;

import java.util.ArrayList;

public class Neuron {
	
	private double value;
	private int activation;
	
	private ArrayList<Double>weights=new ArrayList<Double>();
	private double bias;
	
	public Neuron(int activation) {
		bias=Math.random();
		this.activation=activation;
		for(int i=0;i<weights.size();i++) {
			weights.set(i, Math.random());
		}
	}
	
	public void print() {
		System.out.println("value: "+value);
		System.out.println("activation: "+activation);
		System.out.println("bias: "+bias);
		System.out.println("WEIGHTS");
		for(int i=0;i<weights.size();i++) {
			System.out.println("weight"+i+": "+weights.get(i));
		}
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
