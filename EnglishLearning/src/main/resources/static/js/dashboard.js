'use strict'

document.addEventListener("DOMContentLoaded",function(){
	var num = 0;
	var vocabulary = document.getElementById('vocabulary');
	var btnA = document.getElementById('a');
	var btnB = document.getElementById('b'); 
	var btnC = document.getElementById('c');
	var btnD = document.getElementById('d');
	var start = document.getElementById('start');
	var table = document.getElementById('table-result');
	var correct = document.getElementById('correct');
	var wrong = document.getElementById('wrong');
	var scoreThis =document.getElementById('scoreThis');
	var scoreThat =document.getElementById('scoreThat');
	var correctAnswer="";
	var score = 0 ;
	var btnAudio = document.getElementById('btnAudio');
	var audio = new Audio("/audio/audio.mp3") ;
	function loadQuestion(){	
		
		$.ajax({		
			url:"/api/getQuestion",						
		}).then(function(arr){
			
			num++;
			vocabulary.innerHTML=arr[0];
			correctAnswer = arr[1];
			btnA.innerHTML = arr[2];
			btnB.innerHTML = arr[3];
			btnC.innerHTML = arr[4];
			btnD.innerHTML = arr[5];
			resetColor();
		})
	}
	
	function checkAnswer(){
		
		if(this.innerHTML == correctAnswer){
			score++;
			var row = table.insertRow();		
			var cell0 = row.insertCell(0);
			var cell1 = row.insertCell(1);
			var cell2 = row.insertCell(2);
			var cell3 = row.insertCell(3);
			cell0.innerHTML = vocabulary.innerHTML;
			cell0.classList.add('cell0');
			cell1.innerHTML = correctAnswer;
			cell1.classList.add('cell1');
			cell2.innerHTML = this.innerHTML;
			cell2.classList.add('cell2');
			cell3.innerHTML = '<i class="fas  fa-check-circle" id="correct" ></i>';
			cell3.classList.add('cell3');
			
			
			scoreThis.innerHTML = score;
			scoreThat.innerHTML = score;
			this.style.background="#00ff00";
			this.style.color="#fff";
			
		}else {
			var row = table.insertRow();		
			var cell0 = row.insertCell(0);
			var cell1 = row.insertCell(1);
			var cell2 = row.insertCell(2);
			var cell3 = row.insertCell(3);
			cell0.innerHTML = vocabulary.innerHTML;
			cell0.classList.add('cell0');
			cell1.innerHTML = correctAnswer;
			cell1.classList.add('cell1');
			cell2.innerHTML = this.innerHTML;
			cell2.classList.add('cell2');
			cell3.innerHTML = '<i class="far fa-times-circle" id="wrong" ></i>';
			cell3.classList.add('cell3');
			
			
			this.style.background="red";
			this.style.color="#fff";
			
		}
		
		$.ajax({
			url:"/api/sleep"
			
		}).then(function(){
			loadQuestion();
		});
		
		
	}
	
	function resetColor(){
		var button_answer = document.querySelectorAll('.button-answer');
		for(var i = 0 ; i < button_answer.length;i++){
			button_answer[i].style.background="#fff";
			button_answer[i].style.color="black";
		}
		
		
	}
	var s = 1;
	function enableAudio(){
		if(s == 1) {
			btnAudio.classList.remove('fa-volume-mute');
			btnAudio.classList.add('fa-volume-up');
			audio.play();
			
			
			s=2;
		}else{
			btnAudio.classList.remove('fa-volume-up');
			btnAudio.classList.add('fa-volume-mute');
			audio.pause();
			s=1;
		}
	}
	
	start.addEventListener('click',loadQuestion);
	btnA.addEventListener('click',checkAnswer);
	btnB.addEventListener('click',checkAnswer);
	btnC.addEventListener('click',checkAnswer);
	btnD.addEventListener('click',checkAnswer);
	btnAudio.addEventListener('click',enableAudio);
	

},false)