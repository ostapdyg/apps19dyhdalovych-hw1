package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;
import java.lang.Math;


public class TemperatureSeriesAnalysis {
        private double[] temps;
        private int size;
        private int capacity;
        final double MIN_TEMP = -273.;

    public TemperatureSeriesAnalysis() {
        this.size = 0;
        this.capacity = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temps = new double[0];
        this.size = 0;
        this.capacity = 0;
        this.addTemps(temperatureSeries);
    }

    public double average() {
        this.checkEmpty();
        double sum = 0;
        for (double temp : this.temps) {
            sum+=temp;
        }
        return (sum/this.size);
    }

    public double deviation() {
        double av = this.average();
        double sum = 0;
        for (double temp : this.temps) {
            sum+=(av-temp)*(av-temp);
        }
        return Math.sqrt(sum/this.size);
    }

    public double min() {
        
        return 0;
    }

    public double max() {
        return 0;
    }

    public double findTempClosestToZero() {
        return 0;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        this.checkTemps(temps);
        for (double temp : temps) {
            this.resizeFill(this.size+1, temp);
        }
        return this.size;
    }

    private void resizeFill(int new_size, double fillWith){
        if(new_size>this.capacity){
            int new_capacity = this.capacity;
            while(new_size>new_capacity){
                new_capacity = new_capacity*2+1;
            }
            double[] new_temps = new double[new_capacity];
            System.arraycopy(this.temps, 0, new_temps, 0, this.size);
            this.temps = new_temps;
        }

        for (int i = this.size; i < new_size; i++) {
            this.temps[i] = fillWith;
        }
        this.size = new_size;

    }

    private void checkTemps(double[] temps){
        for (double temp : temps) {
            if(temp<MIN_TEMP){
                throw new InputMismatchException();
            }
        }
    }

    private void checkEmpty(){
        if(this.size == 0){
            throw new IllegalArgumentException();
        }
    }
}
