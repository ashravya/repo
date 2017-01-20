// Validation for enrollment form
//author :shravya



//to validate the username

function validatename() {
			 var name = document.forms["myform"]["username"].value;
			    /*if (name == null || name == "") {
			        alert("Name must be filled out");
			    }*/
			 var letters = "[a-zA-Z]{2,10}";
			 if (!name.match(letters)) {
				 alert("InValid Name");
			    }
} 


//to validate the ID

function validateID(){  
var id=document.myform.id.value;   
  
if (id==null || id==""){  
  alert("ID can't be blank");  
  return false;  
}
}

//to validate the designation

function validateDesignation(){  
var designation=document.myform.designation.value;   
try{
if (designation==null || designation==""){  
  alert("designation can't be blank");  
  return false;  
}
  
   if(designation.value.match(letters))  
     {  
      return true;  
     }  
   else  
     {  
     alert("Only alphabets are allowed");  
     return false;  
     }  
}
}
catch(e){
	alert(e);
}

//to validate the areaOfInterest

function validateAreaOfInterest(){  
var areaOfInterest=document.myform.areaOfInterest.value;   
  
if (areaOfInterest==null || areaOfInterest==""){  
  alert("Area Of Interest can't be blank");  
  return false;  
}
}

//to validate telephone number

function validatetel() {
			 var tel = document.forms["myform"]["tel"].value;
			    /*if (name == null || name == "") {
			        alert("Name must be filled out");
			    }*/
			 var numbers = "^[0-9]{10,10}$";
			 if (!tel.match(numbers)) {
				 alert("InValid Contact");
			    }
} 

//to validate mail id

function validateMail() {
			 var email = document.forms["myform"]["email"].value;
			   var emailReg = "^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]{2,3}$";
			 if (!email.match(emailReg)) {
				 alert("InValid Mail");
			    }
} 

// to validate the form

function validateForm()
{
	//validatename();
	//validateID();
	//validateDesignation();
	//validateAreaOfInterest();
	//validatetel();
	validateMail();
}
