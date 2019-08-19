package ir.alzahra.offerBaz.dto;

/**
 * @author z.moafi
 * @since 13/08/2019
 */
public class MultiWrapperDto <T,E,W> {

    private T t;
    private E e;
    private W w;


    public MultiWrapperDto(T t, E e, W w) {
        this.t = t;
        this.e = e;
        this.w = w;
    }

    public MultiWrapperDto(T t, E e) {
        this.t = t;
        this.e = e;
    }

    public MultiWrapperDto(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public W getW() {
        return w;
    }

    public void setW(W w) {
        this.w = w;
    }
}
