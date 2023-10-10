package Week05_01;

class Container<T> {
    private T item;
    public Container() {
    }

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

public class ContainerExample {
    public static void main(String[] args) {
        Container<String> container1 = new Container<>();
        container1.set("홍길동");
        String str = container1.get();
        System.out.println("문자열 값: " + str);

        Container<Integer> container2 = new Container<>();
        container2.set(6);
        int value = container2.get();
        System.out.println("정수 값: " + value);
    }
}

