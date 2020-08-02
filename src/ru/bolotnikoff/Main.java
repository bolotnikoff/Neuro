package ru.bolotnikoff;

public class Main {

    public static void main(String[] args) {

        // Создаем входные нейроны
        InputNeuron input1 = new InputNeuron();
        input1.neuronNumber = "in1"; // Идентификатор нейрона
        InputNeuron input2 = new InputNeuron();
        input2.neuronNumber = "in2"; // Идентификатор нейрона

        ActiveNeuron hidden1 = new ActiveNeuron(0);
        hidden1.neuronNumber = "h1";
        ActiveNeuron hidden2 = new ActiveNeuron(0);
        hidden2.neuronNumber = "h2";
        ActiveNeuron outputNeuron = new ActiveNeuron(0);
        outputNeuron.neuronNumber = "out";

        // Создаем связи между нейронами
        input1.connect(hidden1, 0.45);          //
        input1.connect(hidden2, 0.78);          //
        input2.connect(hidden1, -0.12);         //Веса
        input2.connect(hidden2, 0.13);          //Соединений
        hidden1.connect(outputNeuron, 1.5);     //
        hidden2.connect(outputNeuron, -2.3);    //

        // Посылаем сигналы в сеть
        input1.excite(null, 1.);
        input2.excite(null, 0.);

        double out1Ideal = 1;

        double result = outputNeuron.getSignal();
        System.out.printf("Output: %3f\n", result);

        // Error = ((1-0.33)^2)/1=0.45
        double error = Math.pow(out1Ideal - result, 2)/1;
        System.out.printf("Error: %3f\n", error);

    }
}
