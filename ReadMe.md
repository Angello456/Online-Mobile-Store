This Includes updated files regarding PAF project.

Team Members and the services they are developing,

Rukshan - User Management Services
Lakshan - Services regarding Shipping Detail Management
Kasun - Product Management Services
Angello - Services regarding placing order(Shopping cart)

.....HOW TO RUN PLACE ORDER....
Extract PlaceOrder and PlaceOrderClient Parts Seperately,and open them using eclipse or STS. Then test the PlaceOrder using Postman and PlaceOrder client using browser. Before running the PlaceOrdeClient application using spring boot, first run the PlaceOrder APi usng spring boot,then run the PlaceOrderClient.
Use, http:// localhost:9090/Order     to start get all function


 ...How Run User Management Services...
... how to run user managment service --
downlord the userManagment and PafClient-2 parts Seperately, and import them eclips or STS. then update the project and run the userManagment using postman and check the all crud operation work propely. after that check the services using PafClient-2( client part) using web browser. 
before run the  PafClient-2 you should run userManagment api
then run the PafClient-2 using http://localhost:8087/user/newuser  to start get all function to start get all function

To run the shipping management service 
IDE - eclipse
Test client - postman
and install xampp
first of all download Shipping_Microservice_SellNBye service from this repository and import it using eclipse then run xampp and execute
apache and mysql module then using phpmyadmin create a database as shipping using related fields in shipping class then run the appication
using ShippingApplication class(AS java application) you almost done open the postman and use the Shipping_Microservice_SellNBye api as i descibed in my individual report
