
var invalidname = document.getElementsById("invalidname");
invalidname.style = "color:green;margin-left:5px";
invalidname.innerHTML = error.firstname;
		
enrol_obj['phone'] = phonenumber;
enrol_obj.phone = phonenumber;
		
var numberEventListener = document.getElementByName("firstname")[0];
numberEventListener.addEventListener('blur', ValidateObject.validatenumber );

var mysearchEvent = new Event("mySearch");

NavigationObj.callEvent = function(){
	search_button.dispatchevent(mysearchEvent);
} 
