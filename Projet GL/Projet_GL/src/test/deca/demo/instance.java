class A {
    public int a;
}


class B extends A{
    A a = new A();


    setB(){
        if( B instanceof A){
            this.a = 2;
        }
    }


}

