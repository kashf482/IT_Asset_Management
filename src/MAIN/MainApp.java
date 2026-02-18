package MAIN;


import DAO.AssetDAO;
import model.Asset;

import java.util.List;
import java.util.Scanner;

public class MainApp {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AssetDAO dao = new AssetDAO();

        while (true) {
            System.out.println("\n--- IT Asset Management System ---");
            System.out.println("1. Add Asset");
            System.out.println("2. View All Assets");
            System.out.println("3. Delete Asset");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Asset Name: ");
                    String name = sc.nextLine();

                    System.out.print("Asset Type: ");
                    String type = sc.nextLine();

                    System.out.print("Serial Number: ");
                    String serial = sc.nextLine();

                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    System.out.print("Assigned To: ");
                    String assigned = sc.nextLine();

                    Asset asset = new Asset(name, type, serial, status, assigned);
                    dao.addAsset(asset);
                    break;

                case 2:
                    List<Asset> assets = dao.getAllAssets();
                    for (Asset a : assets) {
                        System.out.println(a.getId() + " | " +
                                a.getAssetName() + " | " +
                                a.getAssetType() + " | " +
                                a.getStatus());
                    }
                    break;

                case 3:
                    System.out.print("Enter Asset ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteAsset(id);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

}
