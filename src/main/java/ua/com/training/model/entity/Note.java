package ua.com.training.model.entity;

import java.math.BigDecimal;

public class Note extends Accessory {
    private  String noteMessage;

    public String getNoteMessage() {
        return noteMessage;
    }

    public void setNoteMessage(String noteMessage) {
        this.noteMessage = noteMessage;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setBouquetID(long bouquetID) {
        super.setBouquetID(bouquetID);
    }

    @Override
    public long getBouquetID() {
        return super.getBouquetID();
    }

    @Override
    public void setPrice(BigDecimal price) {
        super.setPrice(price);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }
}
