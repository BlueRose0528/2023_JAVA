package practice_03;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> f1=i->i*4;
		System.out.println(f1.apply(3));
		Function<String, Integer> f2=s->s.length();
		System.out.println(f2.apply("Hello"));
		
		Predicate predicate=(v) -> v !=null;
		System.out.println(predicate.test("Hello"));
		
		BiFunction<Integer, Integer, Integer> func=(x1, x2) -> x1+x2;
		Integer result1=func.apply(1,2);
		System.out.println(result1);
		BiFunction<Integer, Integer, Double> func1=(x1, x2)->Math.pow(x1, x2);
		Double result2=func1.apply(10, 2);
		System.out.println(result2);
	}

}
