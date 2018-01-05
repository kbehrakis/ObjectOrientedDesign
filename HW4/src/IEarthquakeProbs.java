import java.util.LinkedList;

interface IEarthquakeProbs {
  LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                           int month);
}