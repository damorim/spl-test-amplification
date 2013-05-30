package com.sleepycat.tests.gettingStarted;

import java.io.File;
import java.io.IOException;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.SecondaryCursor;
 
public class ExampleInventoryRead {

	private static File myDbEnvPath = new File(System.getProperty("user.dir")+"/gsgEnv");

    // Encapsulates the database environment and databases.
    private static MyDbEnv myDbEnv;

    private static TupleBinding inventoryBinding;
    private static EntryBinding vendorBinding;

    // The item to locate if the -s switch is used
    private static String locateItem;

    public static void run(MyDbEnv dbEnv) 
        throws DatabaseException {
    	myDbEnv = dbEnv;
    	
        myDbEnv.setup(myDbEnvPath, // path to the environment home
                      false);      // is this environment read-only?

        // Setup our bindings.
        inventoryBinding = new InventoryBinding();
        vendorBinding =
             new SerialBinding(myDbEnv.getClassCatalog(), 
                               Vendor.class);

        if (locateItem != null) {
            showItem();
        } else {
            showAllInventory();
        }
    }

    private static void showItem() throws DatabaseException {

        SecondaryCursor secCursor = null;
        try {
            // searchKey is the key that we want to find in the 
            // secondary db.
            DatabaseEntry searchKey = 
                new DatabaseEntry(locateItem.getBytes("UTF-8"));

            // foundKey and foundData are populated from the primary 
            // entry that is associated with the secondary db key.
            DatabaseEntry foundKey = new DatabaseEntry();
            DatabaseEntry foundData = new DatabaseEntry();

            // open a secondary cursor
            secCursor = 
                myDbEnv.getNameIndexDB().openSecondaryCursor(null, null);

            // Search for the secondary database entry.
            OperationStatus retVal = 
                secCursor.getSearchKey(searchKey, foundKey, 
                    foundData, LockMode.DEFAULT);

            // Display the entry, if one is found. Repeat until no more 
            // secondary duplicate entries are found
            while(retVal == OperationStatus.SUCCESS) {
                Inventory theInventory = 
                    (Inventory)inventoryBinding.entryToObject(foundData);
                displayInventoryRecord(foundKey, theInventory);
                retVal = secCursor.getNextDup(searchKey, foundKey, 
                    foundData, LockMode.DEFAULT);
            }
        } catch (Exception e) {
            System.err.println("Error on inventory secondary cursor:");
            System.err.println(e.toString());
            e.printStackTrace();
        } finally {
            if (secCursor != null) {
                secCursor.close();
            }
        }
    }

    private static void showAllInventory() 
        throws DatabaseException {
        // Get a cursor
        Cursor cursor = myDbEnv.getInventoryDB().openCursor(null, null);

        // DatabaseEntry objects used for reading records
        DatabaseEntry foundKey = new DatabaseEntry();
        DatabaseEntry foundData = new DatabaseEntry();

        try { // always want to make sure the cursor gets closed
            while (cursor.getNext(foundKey, foundData, 
                        LockMode.DEFAULT) == OperationStatus.SUCCESS) {
                Inventory theInventory = 
                    (Inventory)inventoryBinding.entryToObject(foundData);
                displayInventoryRecord(foundKey, theInventory);
            }
        } catch (Exception e) {
            System.err.println("Error on inventory cursor:");
            System.err.println(e.toString());
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }

    private static void displayInventoryRecord(DatabaseEntry theKey, 
                                        Inventory theInventory)
        throws DatabaseException {

        String theSKU = new String(theKey.getData());
        System.out.println(theSKU + ":");
        System.out.println("\t " + theInventory.getItemName());
        System.out.println("\t " + theInventory.getCategory());
        System.out.println("\t " + theInventory.getVendor());
        System.out.println("\t\tNumber in stock: " + 
            theInventory.getVendorInventory());
        System.out.println("\t\tPrice per unit:  " + 
            theInventory.getVendorPrice());
        System.out.println("\t\tContact: ");

        DatabaseEntry searchKey = null;
        try {
            searchKey = 
                new DatabaseEntry(theInventory.getVendor().getBytes("UTF-8"));
        } catch (IOException willNeverOccur) {}
        DatabaseEntry foundVendor = new DatabaseEntry();

        if (myDbEnv.getVendorDB().get(null, searchKey, foundVendor, 
                LockMode.DEFAULT) != OperationStatus.SUCCESS) {
            System.out.println("Could not find vendor: " + 
                theInventory.getVendor() + ".");
            System.exit(-1);
        } else {
            Vendor theVendor = 
                (Vendor)vendorBinding.entryToObject(foundVendor);
            System.out.println("\t\t " + theVendor.getAddress());
            System.out.println("\t\t " + theVendor.getCity() + ", " + 
                theVendor.getState() + " " + theVendor.getZipcode());
            System.out.println("\t\t Business Phone: " + 
                theVendor.getBusinessPhoneNumber());
            System.out.println("\t\t Sales Rep: " + 
                                theVendor.getRepName());
            System.out.println("\t\t            " + 
                theVendor.getRepPhoneNumber());
       }
    }

}