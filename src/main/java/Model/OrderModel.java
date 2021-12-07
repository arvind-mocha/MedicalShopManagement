package Model;

public class OrderModel {
    private int CustomerId;
    private String OrderId;
    private String DateOfOrder;
    private String PlatFormName;

    public OrderModel(int customerId, String orderId, String dateOfOrder, String platFormName) {
        CustomerId = customerId;
        OrderId = orderId;
        DateOfOrder = dateOfOrder;
        PlatFormName = platFormName;
    }

}
