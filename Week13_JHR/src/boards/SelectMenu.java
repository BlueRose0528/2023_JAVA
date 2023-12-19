switch (menuNo) {
case "1" -> create();
case "2" -> read();
case "3" -> clear();
case "4" -> exit();
}
}

public void create() {
	System.out.println("*** create 메소드 실행됨")
	list();
}

public void read() {
	System.out.println("*** read 메소드 실행됨")
	list();
}

public void clear() {
	System.out.println("*** clear 메소드 실행됨")
	list();
}

public void exit() {
	System.exit(0);
}

public static void main(String[] args) {
	BoardExample2 boardExample=new BoardExample2();
	boardExample.list();
}
}