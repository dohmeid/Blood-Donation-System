public class Receiving {
	private int bloodSampleId;
	private int rssn;
	private String dateOfReceiving;
	private String bloodType;
	private int bloodUnits;
	private String hospital;
	private String doctor;

	public Receiving() {

	}

	public Receiving(int bloodSampleId, int rssn, String dateOfReceiving, String bloodType, int bloodUnits,
			String hospital, String doctor) {
		this.bloodSampleId = bloodSampleId;
		this.rssn = rssn;
		this.bloodUnits = bloodUnits;
		this.bloodType = bloodType;
		this.dateOfReceiving = dateOfReceiving;
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
	 * @return String return the dateOfReceiving
	 */
	public String getDateOfReceiving() {
		return dateOfReceiving;
	}

	/**
	 * @param dateOfReceiving the dateOfReceiving to set
	 */
	public void setDateOfReceiving(String dateOfReceiving) {
		this.dateOfReceiving = dateOfReceiving;
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
