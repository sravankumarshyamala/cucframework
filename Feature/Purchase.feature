Feature: Purchase order
@tag1
Scenario Outline: stock purchase order
Given i opened url "http://webapp.qedgetech.com/login.php"
When i enter my username "admin"
And i enter my password "master"
And i click on login button
And i click on purchases link
And i click on add icon
And i capature purchase number
And i capature purchase date
And i select supplier id "<supplierid>"
And i enter notes "<notes>"
And i enter total amount "<totalamount>"
And i enter total payment "<totalpayment>"
And i click on add button
And i click on confirm record
And i click on add alert record
And i click on search icon
Then i click on logout
And i close my browser

Examples:
|supplierid|notes|totalamount|totalpayment|
|vishnuvardhan|ssk|290|270|
|Akhilesh|ssk1|300|250|
