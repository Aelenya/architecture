package accesUtilisateur;


public class UtilisateurDTO {
	private String email;
	private String pseudo;
	private String password;
	private String response;
	private String confirmMail;
	private String confirmPassword;
	
	public String getConfirmMail() {
		return confirmMail;
	}
	public void setConfirmMail(String confirmMail) {
		this.confirmMail = confirmMail;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		if (confirmPassword.length() > 0) {
		      confirmPassword = confirmPassword.substring(0, confirmPassword.length()-1);
		    }
		this.confirmPassword = confirmPassword;
	}
	public String getResponse(){
		return response;
	}
	public void setResponse(String response){
		this.response = response;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	public String getPseudo(){
		return pseudo;
	}
	
}
