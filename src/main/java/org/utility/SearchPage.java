package org.utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass {
	
	public SearchPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="input-search")
	 public WebElement searchCriteria;
	
	@FindBy(id="list-view")
	 public WebElement listView;
	
	public WebElement getSearchCriteria() {
		return searchCriteria;
	}


	@FindBy(xpath="//ul[@class='thumbnails']")
	 public WebElement ProductDisplay;
	
	public WebElement getProductDisplay() {
		return ProductDisplay;
	}

	@FindBy(id="input-sort")
	public WebElement sort;

	public WebElement getSort() {
		return sort;
	}


	@FindBy(id="grid-view")
	 public WebElement gridView;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	 public WebElement addToCart;
	
	@FindBy(xpath="//button[@*='Add to Wish List']")
	 public WebElement addToWishList;
	
	@FindBy(xpath="//button[@*='Compare this Product']")
	 public WebElement CompareProduct;
	
	
	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getAddToWishList() {
		return addToWishList;
	}

	public WebElement getCompareProduct() {
		return CompareProduct;
	}

	public WebElement getAddToCartSucess() {
		return addToCartSucess;
	}

	@FindBy(xpath="//p[@class='price']")
	 public List<WebElement> price;

	

	public List<WebElement> getPrice() {
		return price;
	}

	@FindBy(xpath="(//div[@id='product-search']//a)[2]")
	 public WebElement ConfirmsearchPage;

	public WebElement getConfirmsearchPage() {
		return ConfirmsearchPage;
	}


	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	 public WebElement addToCartSucess;
	
	@FindBys({@FindBy(xpath="//div[@class='caption']//h4//a")})
	public List<WebElement> searchResults;

	public WebElement getListView() {
		return listView;
	}

	public WebElement getGridView() {
		return gridView;
	}

	public List<WebElement> getSearchResults() {
		return searchResults;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
