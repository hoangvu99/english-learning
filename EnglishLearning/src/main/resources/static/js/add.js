
'use strict'

document.addEventListener('DOMContentLoaded',function(){

	var btn_add = document.getElementById('btn-add');
	var mean_box  = document.getElementById('mean-box');
	var btn_save = document.getElementById('btn-save');
	var category = document.getElementById("select");
	
	function addInput(){			
		mean_box.insertAdjacentHTML('beforeend','<input type="text" class="form-control mee me" name="">')			
		
	}
	btn_add.addEventListener('click',addInput);

	function save(){
		
		var vocab = document.getElementById('vocab');
		var means = document.getElementsByClassName('me');
		var arr = [];
		arr.push(category.value);
		arr.push(vocab.value.trim());
		for (var i = 0; i < means.length; i++) {
			arr.push(means[i].value.trim());
		}
		
		console.log(arr)
		
		$.ajax({
			url:"/api/saveVocabulary",
			method:"post",
			data : JSON.stringify(arr),
			contentType:"application/json",
			success : function(data){
				vocab.value = "";
				for (var i = 0; i < means.length; i++) {
					means[i].value="";
				}
			}
		});
	}

	btn_save.addEventListener('click',save);
	

},false)