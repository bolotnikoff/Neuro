package ru.bolotnikoff;

import java.util.HashSet;
import java.util.Set;

public class InputNeuron implements Neuron {

    /**
     * Идентификатор нейрона
     */
    public String neuronNumber;

    /**
     * Список всех соединений
     */
    private Set<Neuron> connections = new HashSet<>();

    @Override
    public void addInput(Neuron neuron, double weight) {
        // Установка входного нейрона не применима
    }

    @Override
    public void addOutput(Neuron activeNeuron) {
        connections.add(activeNeuron);
    }

    /**
     * Для входного нейрона не требуется обработка входных
     * данных а лишь их ретрансляция на следующий слой
     * поэтому мы просто возбуждаем нейроны следующего слоя
     * @param from
     * @param value
     */
    @Override
    public void excite(Neuron from, double value) {
        connections.forEach(n -> n.excite(this, value));
    }
}
