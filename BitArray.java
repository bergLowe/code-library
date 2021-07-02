public class BitArray {
    int bits;

    public BitArray () {
        this.bits = 0;    
    }

    public boolean get (int bitIndex) {
        return (this.bits & (1 << bitIndex)) > 0;
    }

    public void set (int bitIndex) {
        this.bits |= (1 << bitIndex);
    }

    public boolean isEmpty () {
        return this.bits == 0;
    }

    public void clear () {
        this.bits = 0;
    }
}