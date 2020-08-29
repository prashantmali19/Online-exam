
window.onload = function() {
    show(question_count);
    showTimer();
  
  };

 let question_count=0;
 let points = 0;
 var exam_answer=[];
 var correct_answer=0;
 var wrong_answer=0;
 function next()
 { 

  //console.log(exam_answer[question_count].answer);
    var user_answer = document.querySelector("li.option.active").innerHTML; 

    console.log("user answer :-"+user_answer);
    console.log("correct answer :-"+ exam_answer[question_count].answer);

    if(user_answer==exam_answer[question_count].answer)
    { 
      points += 10;
      correct_answer +=1;
    }else
    {
      wrong_answer +=1;
    }
      
    if(question_count==exam_answer.length-1)
    {
    	clearInterval(my_timer);
    	 let question = document.getElementById("quiz_body");

         question.innerHTML = `
         <h1>Exam Over<h2>
        </br></br>
        <h3>Correct Answer=:${correct_answer}</h3>
        <h3>wrong Answer Answer=:${wrong_answer}</h3>
          
         `;
    	
    }

   // console.log(correct_answer);
   // console.log(wrong_answer);
   
  
      question_count++; 
        show(question_count,user_answer); 
        
 }
 


function show(question_count){
   
    fetch('./json/question.json').then(function (resp) {
        return resp.json();
    }).then(function show(questions){
       let data=questions;
        for(let k=0;k<=questions.length-1;k++)
        {
             exam_answer[k]=questions[k];
        }
      
        
        

        let question = document.getElementById("questions");

        question.innerHTML = `
        <h2>Q${question_count+1}. ${questions[question_count].question}</h2>
         <ul class="option_group">
        <li class="option">${questions[question_count].optionA}</li>
        <li class="option">${questions[question_count].optionB}</li>
        <li class="option">${questions[question_count].optionC}</li>
        <li class="option">${questions[question_count].optionD}</li>

      </ul> 
        `;
        toggleActive();
    });

  

    function toggleActive() {
        let option = document.querySelectorAll("li.option");
        for (let i = 0; i < option.length; i++) {
          option[i].onclick = function() {
            for (let i = 0; i < option.length; i++) {
              if (option[i].classList.contains("active")) {
                option[i].classList.remove("active");
              }
            }
            option[i].classList.add("active");
          };
        }
      }
} 
    
/*  quiz timer start*/

function showTimer(){
    var time="00:10:00";
var timer=document.getElementById("timer");
timer.innerHTML=timer;
my_timer=setInterval(function(){
var hr=0; var min=0; var sec=0;
var time_up=false;
t=time.split(":");
hr=parseInt(t[0]);
min=parseInt(t[1]);
sec=parseInt(t[2]);

if(sec==0)
{
    if(min>0)
    {
        sec=59;
        min--;
    }else if(hr>0)
    {
        min=59;
        sec=59;
        hr--;
    }
    else{
        time_up=true;
    }
}else
{
    sec--;
}

if(hr<10)hr="0"+hr;
if(min<10)min="0"+min;
if(sec<10)sec="0"+sec;

time=hr+":"+min+":"+sec;
if(time_up)
{
    time="time up";
}

var timer=document.getElementById("timer");
timer.innerHTML=time;

if(time_up)
	{
    clearInterval(my_timer);
 let question = document.getElementById("quiz_body");

     question.innerHTML = `
    <center> <h3>Time Up...<h3>
     <h3>Exam Over<h3>

    <h1>Correct Answer=:${correct_answer}</h1>
    <h1>wrong Answer Answer=:${wrong_answer}</h1>
    </center>
    `;
      
}
},1000);

}


/* quiz timer end*/


  

   

  

