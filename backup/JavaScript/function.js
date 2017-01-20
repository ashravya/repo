var namepattern;
var numberpattern;
var mailpattern;
var formerror=false;
var errors=new Array();
var glb_uname="";
var glb_number="";
var glb_mail="";
var validationObj=function(){
    

this.myFunction=function() {

//Password and confirm password validation
    var password=document.forms["enroll"]["password"].value;
    var confirm=document.forms["enroll"]["cpassword"].value;
    
  var firstname= document.forms["enroll"]["fname"].value;
  var secondname=document.forms["enroll"]["sname"].value;
  var gender=document.forms["enroll"]["gender"].value;
  var mail=document.forms["enroll"]["mail"].value;
  var username=document.forms["enroll"]["uname"].value;

  if(formerror==true){
      alert("check");
  }
  else{
  if(password==confirm){
  //alert(firstname +"\n" + secondname+"\n"+mail+"\n"+gender+"\n");
  }
  else
  {
      formerror==true;
      errors.push("incorrect confirm password");
  alert("incorrect confirm password");
  }
}
};
this.validatename=function(){

    var user=document.forms["enroll"]["uname"].value;
    namepattern="[a-zA-Z]{6,15}";
    
    
        
    if(user.match(namepattern)){
        
        debugger;
        glb_uname=user;
        document.getElementById("valid_uname").innerHTML=glb_uname;
        alert("valid username");
    }
    else{
         formerror==true;
         errors.push("incorrect username");
        alert("incorrect username");}
};
     

this.validatenumber=function(){


    var number=document.forms["enroll"]["num"].value;
    numberpattern="[0-9]{10,12}";
    
    try{
    if(number.matches(numberpattern))
        {
        glb_number=number;
        document.getElementById("valid_number").value=glb_number;
        alert("correct number");
        }
    else{
         formerror==true;
         errors.push("incorrect phone number");
        alert("enter proper phone number");}
    }
    catch(err)
    {
        alert("incorrect number");
    }
};
    
this.emailvalidation=function(){
    
    var mail=document.forms["enroll"]["mail"].value;
    mailpattern="[a-zA-z]+@+[a-zA-Z]+\.+[a-zA-Z]"; 
    if(mail.match(mailpattern)){
        glb_mail=mail;
        document.getElementById("valid_mail").value=glb_mail;
        alert("correct mail");
    }
        else{
             formerror==true;
             errors.push("incorrect mail");
            alert("incorrect mail");
        }
    
};

this.focusmethod=function(obj){
    
    obj.style.background="lightcyan";
};
this.doubleclick=function(){
    alert("password should be more than 10 characters");
};



return this;
};