Feature: Verify Search functionality with keyboard Keys

Scenario: Verify we can use all the options of Search functionality using the Keybaord keys

Given Open the Application URL in any supported browser

When Enter search product "HP" in search box and press Enter

And verify Navigated to Search Page

And Enter Search "Mac"product in Search Criteria and press Enter

And Verify multiple products 4 displayed

And Select Search one of subcategories and enter

And Verify multiple products 2 displayed

And Unselect Search in product description and select subCatogory then press Enter

Then Verify multiple products 3 displayed