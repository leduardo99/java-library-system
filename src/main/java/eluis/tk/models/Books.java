package eluis.tk.models;

public class Books extends EntityBase {
    public String Title;
    public String IBSN;
    public int PublisherId;
    public float Price;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getIBSN() {
        return IBSN;
    }

    public void setIBSN(String IBSN) {
        this.IBSN = IBSN;
    }

    public int getPublisherId() {
        return PublisherId;
    }

    public void setPublisherId(int publisherId) {
        PublisherId = publisherId;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
