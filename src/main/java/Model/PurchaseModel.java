package Model;


public class PurchaseModel {
    private String PurchaseId;
    private String DateOfPurchase;
    private String DealerName;
    private int PurchaseAmount;
    private int NoOfItems;
    private String Status;

    public PurchaseModel(String purchaseId, String dateOfPurchase, String dealerName, int purchaseAmount, int noOfItems, String status) {
        PurchaseId = purchaseId;
        DateOfPurchase = dateOfPurchase;
        DealerName = dealerName;
        PurchaseAmount = purchaseAmount;
        NoOfItems = noOfItems;
        Status=status;
    }


    public String getPurchaseId() {
        return PurchaseId;
    }

    public String getDateOfPurchase() {
        return DateOfPurchase;
    }

    public String getDealerName() {
        return DealerName;
    }

    public int getPurchaseAmount() {
        return PurchaseAmount;
    }

    public int getNoOfItems() {
        return NoOfItems;
    }

    public String getStatus() {
        return Status;
    }

}
