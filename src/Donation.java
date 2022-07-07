
public class Donation {
    private int bloodSampleId;
    private int dssn;
    private String dateOfDonation;
    private String bloodType;
    private int bloodUnits;
    private String hospital;
    private String doctor;

    
    public Donation() {
    	
    }
    
    public Donation(int bloodSampleId, int dssn,String dateOfDonation, String bloodType, int bloodUnits, 
            String hospital,String doctor) {
        this.bloodSampleId = bloodSampleId;
        this.dssn = dssn;
        this.bloodUnits = bloodUnits;
        this.bloodType = bloodType;
        this.dateOfDonation = dateOfDonation;
        this.doctor = doctor;
        this.hospital = hospital;
    }

    /**
     * @return int return the bloodSampleId
     */
    public int getBloodSampleId() {
        return bloodSampleId;
    }

    /**
     * @param bloodSampleId the bloodSampleId to set
     */
    public void setBloodSampleId(int bloodSampleId) {
        this.bloodSampleId = bloodSampleId;
    }

    /**
     * @return int return the dssn
     */
    public int getDssn() {
        return dssn;
    }

    /**
     * @param dssn the dssn to set
     */
    public void setDssn(int dssn) {
        this.dssn = dssn;
    }

    /**
     * @return int return the bloodUnits
     */
    public int getBloodUnits() {
        return bloodUnits;
    }

    /**
     * @param bloodUnits the bloodUnits to set
     */
    public void setBloodUnits(int bloodUnits) {
        this.bloodUnits = bloodUnits;
    }

    /**
     * @return String return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return String return the dateOfDonation
     */
    public String getDateOfDonation() {
        return dateOfDonation;
    }

    /**
     * @param dateOfDonation the dateOfDonation to set
     */
    public void setDateOfDonation(String dateOfDonation) {
        this.dateOfDonation = dateOfDonation;
    }

    /**
     * @return String return the doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    /**
     * @return String return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

}
