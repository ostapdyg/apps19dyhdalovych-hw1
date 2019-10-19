package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {
    private final double MIN_TEMP = -273.;
    private double[] temperatures;
    private int size;
    private int capacity;

    public TemperatureSeriesAnalysis() {
        this.size = 0;
        this.capacity = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatures = new double[0];
        this.size = 0;
        this.capacity = 0;
        this.addTemps(temperatureSeries);
    }

    public double average() {
        this.checkEmpty();
        double sum = 0;
        for (double temp : this.temperatures) {
            sum += temp;
        }
        return (sum / this.size);
    }

    public double deviation() {
        this.checkEmpty();
        double av = this.average();
        double sum = 0;
        for (double temp : this.temperatures) {
            sum += (av - temp) * (av - temp);
        }
        return Math.sqrt(sum / this.size);
    }

    public double min() {
        this.checkEmpty();
        double res = this.temperatures[0];
        for (int i = 0; i < this.size; i++) {
            if (temperatures[i] < res) {
                res = temperatures[i];
            }
        }
        return res;
    }

    public double max() {
        this.checkEmpty();
        double res = this.temperatures[0];
        for (int i = 0; i < this.size; i++) {
            if (temperatures[i] > res) {
                res = temperatures[i];
            }
        }
        return res;
    }

    public double findTempClosestToZero() {
        return this.findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        this.checkEmpty();
        double res = this.temperatures[0];
        System.out.println(Arrays.toString(this.temperatures));
        for (int i = 0; i < this.size; i++) {
            if (Math.abs(temperatures[i] - tempValue) < Math.abs(res - tempValue)) {
                res = temperatures[i];
            }
        }
        return res;

    }

    public double[] findTempsLessThen(double tempValue) {
        this.checkEmpty();
        double[] res = new double[this.size];
        int i = 0;
        for (int j = 0; j < this.size; j++) {
            if (temperatures[j] < tempValue) {
                res[i] = temperatures[j];
                i += 1;
            }
        }
        double[] new_res = new double[i];
        System.arraycopy(res, 0, new_res, 0, i);
        return new_res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        this.checkEmpty();
        double[] res = new double[this.size];
        int i = 0;
        for (int j = 0; j < this.size; j++) {
            if (temperatures[j] > tempValue) {
                res[i] = temperatures[j];
                i += 1;
            }
        }
        double[] new_res = new double[i];
        System.arraycopy(res, 0, new_res, 0, i);
        return new_res;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(this.average(), this.deviation(),
                this.min(), this.max());
    }

    public int addTemps(double... temps) {
        this.checkTemps(temps);
        for (double temp : temps) {
            this.resizeFill(this.size + 1, temp);
        }
        return this.size;
    }

    private void resizeFill(int new_size, double fillWith) {
        if (new_size > this.capacity) {
            int new_capacity = this.capacity;
            while (new_size > new_capacity) {
                new_capacity = new_capacity * 2 + 1;
            }
            double[] new_temps = new double[new_capacity];
            System.arraycopy(this.temperatures, 0, new_temps, 0, this.size);
            this.temperatures = new_temps;
        }

        for (int i = this.size; i < new_size; i++) {
            this.temperatures[i] = fillWith;
        }
        this.size = new_size;

    }

    private void checkTemps(double[] temps) {
        for (double temp : temps) {
            if (temp < MIN_TEMP) {
                throw new InputMismatchException();
            }
        }
    }

    private void checkEmpty() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
    }


}
