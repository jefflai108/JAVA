
public class PackageList {

    /** The starting size of the array, set to the value 5. */
    private static final int START_SIZE = 5;

    /** The total allowable weight in pounds for this list, set in the constructor. */
    private final double TOTAL_ALLOWABLE_WEIGHT;
    /** The collection of packages currently in this list. */
    private Package[] list;
    /** The number of items currently in the package list. */
    private int numPackages;
    /** The combined weight of all packages currently in this list. */
    private double totalWeight;

    /**
     * Create a new empty PackageList with capacity START_SIZE, which is 5.
     * @param allowable_weight  the weight limit in pounds for this collection of packages
     */
    public PackageList(double allowable_weight) {
        this.list = new Package[START_SIZE];
        this.numPackages = 0;
        this.totalWeight = 0;
        this.TOTAL_ALLOWABLE_WEIGHT = allowable_weight;
    }

    /**
     * Return the number of packages present in the list.
     * @return  the number of packages in the list
     */
    public int getNumPackages() {
        return this.numPackages;
    }

    /**
     * Return the total weight, in pounds, of all packages present in the list.
     * @return  the total package weight in pounds
     */
    public double getTotalWeight() {
        return this.totalWeight;
    }

    /**
     * Get a string description about a specific package in the list.  Package
     * tracking IDs are matched ignoring case.
     * @param   ID  the tracking number for the package
     * @return  the information about the package, if it exists,
     *          or otherwise "***package not found***".
     */
    public String getPackageInfo(String ID) {

        for (int i = 0; i < this.numPackages; i++) {
            if (this.list[i].getTrackingID().equalsIgnoreCase(ID)) {
                return this.list[i].toString();
            }
        }
        return "***package not found***";
    }
    
    /**
     * Add a new package to the list, if the new item does not have the same
     * tracking ID as an existing package (ignoring case), and if the new item
     * won't put the list over its allowable weight.  If more space is 
     * needed in the list to make this addition, this method doubles the 
     * list's current capacity.
     * 
     * @param trackingID
     *            the unique ID number used to track the package to be added
     * @param length
     *            the length of the package to be addded, in inches
     * @param width
     *            the width of the package to be addded, in inches
     * @param height
     *            the height of the package to be addded, in inches
     * @param weight
     *            the weight of the package to be addded, in pounds
     * @return true if the item was added successfully, or, false if the new item
     *            could not be added to the list                             
     */
    public boolean addEntry(String trackingID, double length, double width,
        double height, double weight) {

        //Create a new package object with the given statistics
        Package newPackage = new Package(trackingID, length, width, height, weight);
        
        //Make sure the package does not duplicate a tracking ID already on the truck
        for (int i = 0; i < this.numPackages; i++) {
            if (trackingID.equalsIgnoreCase(this.list[i].getTrackingID())) {
                return false;
            }
        }
        
        //Make sure the truck can accommodate the additional weight
        if (this.getTotalWeight() + weight > TOTAL_ALLOWABLE_WEIGHT)
            return false;

        //Add capacity to the array if needed
        if (this.numPackages == this.list.length) {
            this.resize();
        }
        
        //Insert new entry into array and increment numPackages
        this.list[this.numPackages++] = newPackage;
        this.totalWeight += weight;
        return true;
    }

    /**
     * Resize the array to double its size so that more packages can be added to
     * the package list.
     */
    private void resize() {
        //Create new array of double the existing size
        int newSize = this.list.length * 2;
        Package[] newList = new Package[newSize];

        //Copy the existing data from the old array into the top of new array
        for (int i = 0; i < this.numPackages; i++) {
            newList[i] = this.list[i];
        }
        //Change which array the list instance variable refers to
        this.list = newList;
    }


    /**
     * Given a trackingID, remove the entry in the list (if any) that
     * matches.  The trackingIDs do not need to match with respect to case.  
     * The resulting list need not store its remaining entries in the same 
     * order as prior to the removal of this package.
     *
     * @param trackingID
     *            the unique ID number that identifies a package
     * @return true if a package was removed, false otherwise
     */
    public boolean removeEntry(String trackingID) {
        
        //Start searching from bottom of array so that moving up one item
        //from bottom doesn't cause the item to be missed
        for (int i = this.numPackages-1; i >= 0; i--) {
            //If find item, decrement numPackages and move up last item in 
            //list to take its place before returning it
            if (this.list[i].getTrackingID().equalsIgnoreCase(trackingID)) {
                this.totalWeight -= this.list[i].getWeight();
                numPackages--;
                list[i] = list[numPackages];
                return true;
            }
        }

        //If we reach this line, item was not found
        return false;  
    }


    /**
     * Return a String containing all the packages in the package list,
     * on separate lines, with details for each package presented
     * exactly as indicated by the Package's toString() method.
     * No particular ordering of the packages is guaranteed.
     * If the package list currently contains no items, the returned String
     * is "***no entries present***".
     * @return  a string description of the packages currently present in the list
     */
    public String toString() {
        String s = "";
        if (this.numPackages == 0) {
            s = "***no entries present***";
        } else {
            for (int i = 0; i < this.numPackages; i++) {
                s = s + this.list[i] + "\n";
            }
        }
        return s;
    }

    /**
     * Return a String containing all the oversize packages in the package list,
     * one per line, with details as given by the Package's toString()
     * method.  No particular ordering of the packages is guaranteed.
     * If the package list currently contains no oversize items, the returned String
     * is "***no oversize entries present***".
     * @return the list of packages that are classified as oversize
     */
    public String getOversizePackageList() {
        String s = "";
        for (int i = 0; i < this.numPackages; i++) {
            if (this.list[i].isOversize()) {
                s = s + this.list[i] + "\n";
            }
        }
        if (s.equals("")) {  //check if there were any reported (incl. if list empty)
            s = "***no oversize entries present***";
        }
        return s;
    }





}