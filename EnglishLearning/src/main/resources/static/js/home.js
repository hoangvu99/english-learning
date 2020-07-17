'use strict'
document.addEventListener('DOMContentLoaded',function(){
	
	let item = document.getElementsByClassName("grid-item");
	
	
	
	function sendData(){
		
		$.ajax({
			url: "/test?category="+this.innerText,
			
			
		}).then(function(){
			console.log("success");
		});
		
	}
	for(let i = 0 ; i < item.length;i++){
		item[i].addEventListener('click',sendData);
	}
	
	
},false)