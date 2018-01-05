class CandidateExistsException extends Exception {
	
	String existingName;  
	CandidateExistsException(String name) {
	      this.existingName = name;
	}
	
	public String getExistingName() {
		    return this.existingName;
	}
}