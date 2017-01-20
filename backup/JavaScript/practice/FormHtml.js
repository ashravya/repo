/**
 * sample js file to be included to be included in page.html
 * 
 * @author= abc This file is for validation of form .
 */
/* global variables to store the validated data*/
// In JSON get the values from html for injection or we can store back to JSON object after verification
var enrol_obj={};// how to make use of this JSON object either use a square braces or a dot operator to add values.
var enrol_array=[];
var global_name="";
var global_email="";
var global_phone_number;
var patterns={
		namepattern : /[a-zA-Z]{5,10}/,
		 phonepattern : /[0-9]{10,10}/,
		 emailpattern  : /^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]/
			}
// 2. var validatorobject = function(){functions as this.functionname=function(){}}
var validatorobject =  {
	//this.validateName=function()
	validateName:function() {	
		//2 .var namepattern = /[a-zA-Z]{5,10}/;
		var namepattern=patterns.namepattern;
		var firstName = document.formname.firstname.value;
		if (firstName=="") {
			alert("firstname could not be empty");
			//alert("<span style="color: #ff0000;margin-left: 5px;"> error</span>");
		}
		if (!firstName.match(namepattern)) {
			alert("the first name is validated successfully");
		}
		enrol_obj.name=firstName;
	/*	enrol_obj.name=firstName;*/
		global_name=firstName;
	
	},
validatePhone:function() {
		 var phonepattern = /[0-9]{10,10}/; 
		 var phone =document.formname.phonenumber.value;
		 if (phone=="") { 
			 alert("phone numbercould not be empty");
			 } 
		 if (!phone.match(phonepattern)) {
			 alert("phone number validated successfully");
			 } 
	enrol_obj.phonenumber=phone;
		 global_phone_number=phone; //instead of displaying in html after verifying the phone number by JS from client side store it in JSON object
		 },
	 
	validateEmail:function() {
			var emailpattern =/^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]/;
			var email= document.formname.email.value;
			if (email=="") {
				alert("email could not be empty");

			}
			else
			if (email.match(emailpattern)) {
				alert("email validated successfully");
			}
		 enrol_obj.email=email;
			global_email=email;
	},
	



 display:function() {
	 var vDataDiv=document.getElementById('valid_data');
		var firstName = document.formname.firstname.value;
		var phone =document.formname.phonenumber.value;
		var email= document.formname.email.value;
		// 2. this.validateName();
		validatorobject.validateName();
		/*this.*/validatorobject.validatePhone();
		/*this.*/validatorobject.validateEmail();
 /* document.getElementById('valid_name').innerHTML=enrol_obj.name;
  document.getElementById('valid_email').innerHTML=enrol_obj.email;
  document.getElementById('valid_phone').innerHTML=	enrol_obj.phonenumber;*/
  //1. enrol_array.push(enrol_obj);
  enrol_array.push(JSON.parse(JSON.stringify(enrol_obj)));
  var temp="";
  for(var i=0;i<enrol_array.length;i++)
	  {
	  /* 1. temp+=enrol_array[i].name+",";
	  temp+=enrol_array[i].email+",";
	  temp+=enrol_array[i].phonenumber+";";
	  document.getElementById('arrayvalues').innerHTML=	temp;
	  var error_div=document.createElement('div');
	  error_div.innerHTML=temp;
	  document.body.appendChild(error_div);*/
	  var inner_div=document.createElement('div');
	  vDataDiv.appendChild(inner_div);
	  var nameSpan=document.createElement('span');
	  var phoneSpan=document.createElement('span');
	  nameSpan.innerHTML=enrol_obj.name;
	  phoneSpan.innerHTML=enrol_obj.phonenumber;
	  inner_div.appendChild(nameSpan);
	  inner_div.appendChild(phoneSpan);
	
	  
	  }
   }
 // return this;
};

var phonenumberEle =document.forms[0].elements[1];
phonenumberEle.addEventListener('blur',ValidatorObject.validatePhone);

 //Json objects updated dynamically and injected dynamically
//var obj=
/*{
 *  name:"abc",
 * phone:
 * validateEmail:function(){
 *  code goes here
 *}
 *};
 *obj.validateEmail()=function(){or write here
 *vara;
 *hhh();  };
 *no nan infinity , hexa octal
 *use null
 *take in string"asdh72" convert to hexa
 *
 *
 
 */
