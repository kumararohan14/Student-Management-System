public class Student {
    private String id;
    private String name;
    private String address;
    private int dbmsMarks;
    private int prfMarks;

    // Constructor
    public Student(String id, String name, String address, int dbmsMarks, int prfMarks) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dbmsMarks = dbmsMarks;
        this.prfMarks = prfMarks;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getDbmsMarks() {
        return dbmsMarks;
    }

    public int getPrfMarks() {
        return prfMarks;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDbmsMarks(int dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public void setPrfMarks(int prfMarks) {
        this.prfMarks = prfMarks;
    }
}
 
