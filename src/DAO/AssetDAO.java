package DAO;

import model.Asset;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssetDAO {

    public void addAsset(Asset asset) {
        String query = "INSERT INTO assets (asset_name, asset_type, serial_number, status, assigned_to) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, asset.getAssetName());
            ps.setString(2, asset.getAssetType());
            ps.setString(3, asset.getSerialNumber());
            ps.setString(4, asset.getStatus());
            ps.setString(5, asset.getAssignedTo());

            ps.executeUpdate();
            System.out.println("Asset added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Asset> getAllAssets() {
        List<Asset> list = new ArrayList<>();
        String query = "SELECT * FROM assets";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Asset asset = new Asset();
                asset.setId(rs.getInt("id"));
                asset.setAssetName(rs.getString("asset_name"));
                asset.setAssetType(rs.getString("asset_type"));
                asset.setSerialNumber(rs.getString("serial_number"));
                asset.setStatus(rs.getString("status"));
                asset.setAssignedTo(rs.getString("assigned_to"));

                list.add(asset);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteAsset(int id) {
        String query = "DELETE FROM assets WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Asset deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
