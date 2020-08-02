package ru.bolotnikoff;

public interface Neuron {

    void addInput(Neuron neuron, double weight);

    void addOutput(Neuron activeNeuron);

    /**
     * Метод принимает {@link Neuron} в качестве выходного
     * нейрона и соединяет ему на вход текущий
     * @param neuron
     * @param weight
     */
    default void connect(Neuron neuron, Double weight) {
        this.addOutput(neuron);
        neuron.addInput(this, weight);
    }

    /**
     *
     * @param from
     * @param value
     */
    void excite(Neuron from, double value);

}
