package Week06_02;

interface ArrayProcessing {
    double apply(double[] array);
}

public class RamdaTest {
    public static void main(String[] args) {
        double[] numbers = {12.5, 3.7, 9.2, 6.4, 15.1};

        ArrayProcessing maxCalculator = array -> {
            double max = array[0];
            for (double num : array) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        };

        double maxResult = maxCalculator.apply(numbers);
        System.out.println("최대값: " + maxResult);
     
        ArrayProcessing minCalculator= array -> {
            double min = array[0];
            for (double num : array) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        };

        double minResult = minCalculator.apply(numbers);
        System.out.println("최소값: " + minResult);

        ArrayProcessing averageCalculator = array -> {
            double sum = 0;
            for (double num : array) {
                sum += num;
            }
            return sum / array.length;
        };

        double averageResult = averageCalculator.apply(numbers);
        System.out.println("평균값: " + averageResult);
    }
}
