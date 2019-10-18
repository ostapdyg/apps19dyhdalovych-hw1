package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {
    TemperatureSeriesAnalysis oneElemAnalysis;
    TemperatureSeriesAnalysis emptyAnalysis;
    TemperatureSeriesAnalysis analysis;

    @Before
    public void setup(){
        double[] oneElemSeries = {-1.0};
        oneElemAnalysis = new TemperatureSeriesAnalysis(oneElemSeries);
        double[] EmptySeries = {};
        emptyAnalysis = new TemperatureSeriesAnalysis(EmptySeries);
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        analysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double expResult = -1.0;

        // call tested method
        double actualResult = analysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        // expect exception here
        emptyAnalysis.average();
    }


    @Test
    public void testAverage() {

        double expResult = 1.0;

        double actualResult = analysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double expResult = -0.0;
        double actualResult = oneElemAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        emptyAnalysis.deviation();
    }

    @Test
    public void testDeviation() {

        double expResult = 3.84057287;

        double actualResult = analysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }



}
