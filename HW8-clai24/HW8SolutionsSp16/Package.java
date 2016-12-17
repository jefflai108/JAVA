
public class Package {

    /** The limit of the "linear inch" measurement for packages, set to 60; any
        package with linear inch measurement greater than this is "OVERSIZE".
        Since this is a static constant, it is shared among all instances
        of this class, and its value will never change. */
    public static final int LINEAR_INCHES_LIMIT = 60;

    /** String ID number for the package */
    private String trackingID;
    /** length of the package in inches */
    private double length;
    /** width of the package in inches */
    private double width;
    /** height of the package in inches */
    private double height;
    /** weight of the package in pounds */
    private double weight;
    
    /** 
     *  Creates a new package item with the given data.
     *  @param trackingID   the String identifier for the package
     *  @param length       the length of the package in inches  
     *  @param width        the width of the package in inches  
     *  @param height       the height of the package in inches  
     *  @param weight       the weight of the package in pounds  
     */
    public Package(String trackingID,
                   double length,
                   double width,
                   double height,
                   double weight) {
        this.trackingID = trackingID;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }
    
    /**
     *  Gets the tracking ID for this package.
     *  @return the tracking ID String
     */
    public String getTrackingID() {
        return this.trackingID;
    }    

    /** 
     *  Gets the weight of this package.
     *  @return the weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /** 
     *  Gets the "linear inch" measurement of this package.
     *  This is defined as the sum of length, width, and height of
     *  the package, all given in inches.
     *  @return the linear inch measurement of this package
     */
    private double getLinearInches() {
        return length + width + height;
    }
    
    /**
     *  Determine if the given package is classified as "oversize",
     *  meaning that its linear inch measurement is greater than
     *  the LINEAR_INCHES_LIMIT.
     *  @return true if it is oversize, and false otherwise
     */
    public boolean isOversize() {
        return this.getLinearInches() > LINEAR_INCHES_LIMIT;
    }
    
    /**
     *  Return a two-line string representation of this package, in the form
     *  matching examples given in the assignment description.
     *  Note that the second line is indented by two spaces, and, if the
     *  package is classified as oversize, ends with the notation OVERSIZE.
     *  @return the two-line string description of the package
     */
    public String toString() {
        String s = "Package tracking ID: " + this.trackingID + "\n" +
                   "  length: " + this.length +
                   "  width:  " + this.width +
                   "  height: " + this.height +
                   "  weight: " + this.weight;
         if (this.isOversize()) {
            s = s + "  OVERSIZE";
         }
         return s;
    }

}