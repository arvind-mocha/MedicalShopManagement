package Model;

public class CustomerModel{
    private int Id;
    private String Name;
    private String MobileNumber;
    private String DateOfPurchase;
    private String PlatformName;
    private String ItemName;
    private int Quantity;

    public CustomerModel(int id, String name, String mobileNumber, String dateOfPurchase, String platformName, String itemName, int quantity) {
        Id = id;
        Name = name;
        MobileNumber = mobileNumber;
        DateOfPurchase = dateOfPurchase;
        PlatformName = platformName;
        ItemName = itemName;
        Quantity = quantity;
    }

    public CustomerModel(int id, String name, String mobileNumber) {
        Id = id;
        Name = name;
        this.MobileNumber = mobileNumber;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getDateOfPurchase() {
        return DateOfPurchase;
    }

    public String getPlatformName() {
        return PlatformName;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getQuantity() {
        return Quantity;
    }



}
