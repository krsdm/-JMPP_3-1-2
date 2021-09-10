package test;

public class SinglObject {
    private static final SinglObject singlObject = new SinglObject();

    private SinglObject() {
    }

    public static SinglObject getSinglObject() {
        return singlObject;
    }
}
