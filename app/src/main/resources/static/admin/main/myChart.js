var month1 = "1월";
var month2 = "2월";
var month3 = "3월";
var month4 = "4월";
var month5 = "5월";
var month6 = "6월";
var month7 = "7월";
var month8 = "8월";
var month9 = "9월";
var month10 = "10월";
var month11 = "11월";
var month12 = "12월";

var barChartData = {                
labels: [`${month1}`, `${month2}`, `${month3}`, `${month4}`, `${month5}`, `${month6}`,
				 `${month7}`, `${month8}`, `${month9}`, `${month10}`, `${month11}`, `${month12}`],
datasets: [{
  label: '총 회원수',
  backgroundColor: "#1E90FF",
  data: [
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20)
    ]
}, {
  label: '총 크리에이터 수',
  backgroundColor: "#F7464A",
  data: [
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20)
    ]
}, {
	  label: '신규 회원 수',
	  backgroundColor: "green",
	  data: [
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20),
	    Math.ceil(Math.random()*20)
	    ]
	}
]
};
window.onload = function()
{
var ctx = $('#chart').get(0).getContext("2d");
window.theChart = new Chart(ctx, {
type: 'bar',
data: barChartData,
options: {
  
}
});
}