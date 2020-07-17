'use strict'
document.addEventListener('DOMContentLoaded',function(){

	var fields = document.querySelectorAll('.input-control input');
	var btn = document.querySelector('.btn');

	function check(){
		if( fields[0].value != "" && fields[1].value != ""){
			btn.style.background = "#bc252a";
			btn.style.opacity="0.85";
		}else{
			btn.style.background="#fff";
			btn.color="#ddd";
			btn.onmouseover = function(){
				
				btn.style.background = "#bc252a";
				btn.style.opacity = "0.85";

			}
			btn.onmouseout = function(){
				btn.style.background = "#fff";
			}
			
			
		}
	}
	fields[0].addEventListener("keyup",check);
	fields[1].addEventListener("keyup",check);

	var eye_current = 1;
	var show_password = document.getElementById('show-password');
	
	
	function showPassWord(){
		if (eye_current == 1 ){
			show_password.classList.remove('fa-eye-slash');
			show_password.classList.add('fa-eye');
			fields[1].type = "text";
			eye_current=2
			
		}else {
			show_password.classList.remove('fa-eye');
			show_password.classList.add('fa-eye-slash');
			fields[1].type = "password";
			eye_current=1;
		}
	}

	show_password.addEventListener("click",showPassWord);

},false)


