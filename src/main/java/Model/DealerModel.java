package Model;

public class DealerModel {
    private String DealerName;
    private String DealerNumber;

    public DealerModel(String dealerName, String dealerNumber) {
        DealerName = dealerName;
        DealerNumber = dealerNumber;
    }

    public String getDealerName() {
        return DealerName;
    }

    public String getDealerNumber() {
        return DealerNumber;
    }
}
