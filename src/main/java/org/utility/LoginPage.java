package org.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(name="search")
	private WebElement SearchBox;
	
	public WebElement getSearchBox() {
		return SearchBox;
	}



	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;
	}



	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//input[@class='form-control input-lg']")
	private WebElement searchProduct;
	
	
	public WebElement getSearchProduct() {
		return searchProduct;
	}


	public void setSearchProduct(WebElement searchProduct) {
		this.searchProduct = searchProduct;
	}


	public void setLogoutButton(WebElement logoutButton) {
		this.logoutButton = logoutButton;
	}


	@FindBy(xpath="(//a[text()='Login'])[1]")
	private WebElement login;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	
	@FindBy(id="input-password")
	private WebElement pass;
	
	@FindBy(xpath="(//a[text()='Logout'])[1]")
	private WebElement logoutButton;
	
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}


	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginButton;

	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	private WebElement Logout;

	public WebElement getLogout() {
		return Logout;
	}


	public void setLogout(WebElement editAccount) {
		this.Logout = editAccount;
	}


	public WebElement getMyAccount() {
		return myAccount;
	}


	public void setMyAccount(WebElement myAccount) {
		this.myAccount = myAccount;
	}


	public WebElement getLogin() {
		return login;
	}


	public void setLogin(WebElement login) {
		this.login = login;
	}


	public WebElement getEmail() {
		return email;
	}


	public void setEmail(WebElement email) {
		this.email = email;
	}


	public WebElement getPass() {
		return pass;
	}


	public void setPass(WebElement pass) {
		this.pass = pass;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}


	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
	
	
	
	

}
