package model;

public class Asset {
    private int id;
    private String assetName;
    private String assetType;
    private String serialNumber;
    private String status;
    private String assignedTo;

    public Asset() {}

    public Asset(String assetName, String assetType,
                 String serialNumber, String status, String assignedTo) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.serialNumber = serialNumber;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }

    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
}
