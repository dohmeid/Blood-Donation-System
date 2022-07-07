
public class Donor {
    private int dssn;
    private String dname;
    private int phoneNumber;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String bloodType;
    private int bloodHgb;
    private String eligableToDonate;
    
    public Donor() { 	
    }
   
    public Donor(int dssn, String dname, int phoneNumber, String address, String dateOfBirth, String gender,
            String bloodType, int bloodHgb, String eligableToDonate) {
        this.dssn = dssn;
        this.dname = dname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodType = bloodType;
        this.bloodHgb = bloodHgb;
        this.eligableToDonate = eligableToDonate;
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
     * @return String return the dname
     */
    public String getDname() {
        return dname;
    }

    /**
     * @param dname the dname to set
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * @return int return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @return int return the bloodHgb
     */
    public int getBloodHgb() {
        return bloodHgb;
    }

    /**
     * @param bloodHgb the bloodHgb to set
     */
    public void setBloodHgb(int bloodHgb) {
        this.bloodHgb = bloodHgb;
    }

    /**
     * @return String return the eligableToDonate
     */
    public String getEligableToDonate() {
        return eligableToDonate;
    }

    /**
     * @param eligableToDonate the eligableToDonate to set
     */
    public void setEligableToDonate(String eligableToDonate) {
        this.eligableToDonate = eligableToDonate;
    }

	@Override
	public String toString() {
		return "Donor [dssn=" + dssn + ", dname=" + dname + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", bloodType=" + bloodType + ", bloodHgb="
				+ bloodHgb + ", eligableToDonate=" + eligableToDonate + "]";
	}
    
    

}
