package Model;

public class OrderedItemModel {

    private String OrderId;
    private String ItemId;
    private int Quantity;

    public String getOrderId() {
        return OrderId;
    }

    public String getItemId() {
        return ItemId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public OrderedItemModel(String orderId, String itemId, int quantity) {
        OrderId = orderId;
        ItemId = itemId;
        Quantity = quantity;
    }


}
