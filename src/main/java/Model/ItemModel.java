package Model;

public class ItemModel {
    private String ItemName;
    private String ExpiryDate;
    private String PurchaseId;
    private String ItemId;
    private int PricePerUnit;
    private int AvailableStock;

    public String getItemName() {
        return ItemName;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public String getPurchaseId() {
        return PurchaseId;
    }

    public String getItemId() {
        return ItemId;
    }

    public int getPricePerUnit() {
        return PricePerUnit;
    }

    public int getAvailableStock() {
        return AvailableStock;
    }

    public ItemModel(String itemName, String expiryDate, String purchaseId, String itemId, int pricePerUnit, int availableStock) {
        ItemName = itemName;
        ExpiryDate = expiryDate;
        PurchaseId = purchaseId;
        ItemId = itemId;
        PricePerUnit = pricePerUnit;
        AvailableStock = availableStock;
    }
}
