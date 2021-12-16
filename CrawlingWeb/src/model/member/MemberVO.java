package model.member;

public class MemberVO {
    private String uid;
    private String upw;
    private String uname;
    private String uemail;
    private int ufav;

    @Override
    public String toString() {
        return "MemberVO{" +
                "uid='" + uid + '\'' +
                ", upw='" + upw + '\'' +
                ", uname='" + uname + '\'' +
                ", uemail='" + uemail + '\'' +
                ", ufav=" + ufav +
                '}';
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUpw(String upw) {
        this.upw = upw;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public void setUfav(int ufav) {
        this.ufav = ufav;
    }

    public String getUid() {
        return uid;
    }

    public String getUpw() {
        return upw;
    }

    public String getUname() {
        return uname;
    }

    public String getUemail() {
        return uemail;
    }

    public int getUfav() {
        return ufav;
    }
}
