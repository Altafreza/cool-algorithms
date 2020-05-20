package contestquestions;

public class mxa {

}

class A {

    final void meth() {

        System.out.println("This is a final method.");

    }

}

class B extends A {

    void meth() {

        System.out.println("Illegal!");

    }

}

private class Base{

    Base(){

        int i = 100;

        System.out.println(i);

    }

}



public class exte extends Base{

    static int i = 200;

    public static void main(String argv[]){

        exte p = new exte();

        System.out.println(i);

    }

}