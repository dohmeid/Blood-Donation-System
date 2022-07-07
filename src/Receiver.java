
public class Receiver {
    private int rssn;
    private String rname;
    private int phoneNumber;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String bloodType;
    
    public Receiver() {
    	
    }

    public Receiver(int rssn, String rname, int phoneNumber, String address, String dateOfBirth, String gender,
            String bloodType) {
        this.rssn = rssn;
        this.rname = rname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodType = bloodType;
    }

    /**
     * @return int return the rssn
     */
    public int getRssn() {
        return rssn;
    }

    /**
     * @param rssn the rssn to set
     */
    public void setRssn(int rssn) {
        this.rssn = rssn;
    }

    /**
     * @return String return the rname
     */
    public String getRname() {
        return rname;
    }

    /**
     * @param rname the rname to set
     */
    public void setRname(String rname) {
        this.rname = rname;
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

	@Override
	public String toString() {
		return "Receiver [rssn=" + rssn + ", rname=" + rname + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", bloodType=" + bloodType + "]";
	}
    
    

}
