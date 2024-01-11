public class runner{
    public static void main(String[] args){
        StringMethods test = new StringMethods();
        test.unusualHello("Ron");
        System.out.println(test.stringRipper("something"));
        System.out.println(test.evenFooBar("foofoobarbarfoo"));
        System.out.println(test.sumString("there 9 are many benefits 2 to becoming a marine 1 biologist 6"));
        System.out.println(test.decode("hello world", "6405372"));

    }
}