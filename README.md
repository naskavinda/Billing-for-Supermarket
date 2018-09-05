# Billing for Super Market
note : This application still in under construction

This is the software part of the my final year project call "Shopping Assistant Trolley with Automatic Billing for Super Market"

##Instruction for run this project 

After clone this project first thing is you should config MySQL properties.
* Open the `application.properties` file It is in the resources folder. 

  There have two properties `spring.datasource.username` and `spring.datasource.password`. In there you should give your MySQL database username and password.
  
  Create new schema and name it `supermarket`
* Please make sure your `9090` port is not used. if it used change the port number.
* Install Lombok plugin to your ID. 

After configuring those things you can run project.

* Then open the browser and go to `http://localhost:9090/swagger-ui.html`