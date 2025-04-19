public class Student {
    private String name;
    private long prn;
    private String branch;
    private String batch;
    private double cgpa;
    
    public Student(String name, long prn, String branch, String batch, double cgpa) {
        this.name = name;
        this.prn = prn;
        this.branch = branch;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    public String getName() { return name; }
    public long getPrn() { return prn; }
    public String getBranch() { return branch; }
    public String getBatch() { return batch; }
    public double getCgpa() { return cgpa; }
