package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {
    private TemperatureSeriesAnalysis oneElemAnalysis;
    private TemperatureSeriesAnalysis emptyAnalysis;
    private TemperatureSeriesAnalysis analysis;

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
        double actualResult = oneElemAnalysis.average();

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

    @Test
    public void testMinWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = oneElemAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        emptyAnalysis.min();
    }

    @Test
    public void testMin() {

        double expResult = -5.0;

        double actualResult = analysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = oneElemAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        emptyAnalysis.max();
    }

    @Test
    public void testMax() {

        double expResult = 5.0;

        double actualResult = analysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = oneElemAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        emptyAnalysis.findTempClosestToZero();
    }

    @Test
    public void testClosestToZero() {

        double expResult = 1.0;

        double actualResult = analysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = oneElemAnalysis.findTempClosestToValue(2.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        emptyAnalysis.findTempClosestToValue(2.0);
    }

    @Test
    public void testClosestToValue() {

        double expResult = 3.0;

        double actualResult = analysis.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }
}
