/**
 * This is included in SampleJS1.html
 * 
 * this validates enrollment form
 */



var gbl_name="";
var gbl_phonenumber="";
var gbl_email="";

var patterns={namePattern : /[a-zA-Z]{6,10}/, phonePattern : /[0-9]{10,10}/,emailPattern : /^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]{2,4}/};
/*
 * var namePattern = /[a-zA-Z]{6,10}/; var phonePattern = /[0-9]{10,10}/;
 */
var emailPattern = /^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]{2,4}/;
var err_array = new Array();

var ValidatorObject = {
	validateName:function() {
		var name = document.forms[0].elements[0].value; 
		if (name == "") {
			alert("name cannot be blank..!!");
			return ;
			err_array.push("name cannot be blank..!!");
		} else if (!name.match(patterns.namePattern)) {
			alert("Enter only alphabets");
			return ;
			err_array.push("Enter only alphabets");
		}
		gbl_name=name;
		document.getElementById('valid_name').innerHTML=gbl_name;
	},
	
	validatePhoneNumber : function() {
		var phonenumber = document.forms[0].elements[1].value;
		if (phonenumber == "") {
			alert("phone number cannot be empty");
			console.log("Enter only numbers");
			return;
			err_array.push("Phone number cannot be empty");
		} else if (!phonenumber.match(patterns.phonePattern)) {
			alert("enter 10 digit phone number with numbers");
			/* console.log("Enter only numbers"); */
			return;
			/* err_array.push("Enter only numbers"); */
		}
		gbl_phonenumber=phonenumber;
		document.getElementById('valid_phone').innerHTML=gbl_phonenumber;
	},
	

	 validateEmail :  function() {
		debugger;
		var email = document.forms[0].elements[2].value;
		if (email.match(emailPattern)) {
			alert("type correct email");
			return false;
			err_array.push("type correct email");
		}
		gbl_email=email;
	},

	validateGender : function() {
		if (!check()) {
			alert("Select gender. Gender cannot be empty");
			return false;
			err_array.push("Gender cannot be empty");
		}
		function check() {
			var radios = document.getElementsByName("gender");
			for (var i = 0, len = radios.length; i < len; i++) {
				if (radios[i].checked) {
					return true;
				}
			}
			return false;
		}
	}

	/*
	 * function displayErrors() { var temp; for (i = 0; i < err_array.length;
	 * i++) { temp = temp + err_array[i] + "\n"; } alert(temp); }
	 */
	/*return this;*/
};

/*
 * function display() {
 * 
 * var name=document.forms[0].elements[0].value; var
 * phonenumber=document.forms[0].elements[1].value; var
 * email=document.forms[0].elements[2].value; var
 * dob=document.forms[0].elements[3].value; var
 * gender=document.forms[0].elements[4].value; var
 * address=document.forms[0].elements[5].value; var
 * city=document.forms[0].elements[6].value; var
 * pin=document.forms[0].elements[7].value;
 * 
 * validateName(); validatePhoneNumber(); validateEmail(); validateGender();
 * displayErrors(); }
 * 
 */