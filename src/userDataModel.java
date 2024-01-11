public class userDataModel {
    private int id;
    private String email;
    private String password;
    private String name;
    private String education;
    private String phoneNo;
    private byte[] profileImage;

    // Getter methods
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEducation() {
        return education;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

}

