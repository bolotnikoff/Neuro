package ru.bolotnikoff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ActiveNeuron implements Neuron{

    /**
     * Идентификатор нейрона
     */
    public String neuronNumber;

    private Map<Neuron, Double> input = new HashMap<>();
    private Set<Neuron> output = new HashSet<>();

    private volatile int signalsReceived;
    private volatile double bias;
    private volatile double charge;
    private volatile double signal;

    public ActiveNeuron(){
        super();
    }

    public ActiveNeuron(double bias){
        this.bias = bias;
    }

    public void addInput(Neuron neuron, double weight){
        input.put(neuron, weight);
    }

    public void addOutput(Neuron activeNeuron){
        output.add(activeNeuron);
    }

    public void excite(Neuron from, double value){
        signalsReceived++;

        System.out.println("Exciting of "+ neuronNumber +" with weight "+ (input.get(from)) +"is: " + value);

        charge += (input.get(from) * value);

        if (input.size() == signalsReceived){

            signal = (1 / (1 + Math.exp(-charge))) + bias;

            output.stream().forEach(
                    outLink -> outLink.excite(this, signal)
            );

            System.out.println("Sigmoid of "+ neuronNumber +" and charge " + charge + "is : "+signal);

            signalsReceived = 0;
        }

    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getSignal(){
        return signal;
    }
}
