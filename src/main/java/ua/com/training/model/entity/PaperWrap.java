package ua.com.training.model.entity;

public class PaperWrap extends Accessory {
    private long length;

    public void setLength(long length) {
        this.length = length;
    }

    public long getLength() {
        return length;
    }

@Override
    public String toString(){
        return "price "+getPrice()+ " name "+ getName();
}
}
