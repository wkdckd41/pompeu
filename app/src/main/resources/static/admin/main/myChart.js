var total = [];
var TT = 12;
var creator = []; 
var rookie = [];

  fetch(`/adminMain/memberSummary`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {

	for(i=0; i < 12; i++) {
		if (result[i] == null) {
			result[i] = {MonRookie: 0, MonCreator: 0, MonTotal: 0}
		}
		total[i] = result[i].MonTotal
		creator[i] = result[i].MonCreator
		rookie[i] = result[i].MonRookie
	}
    });

var barChartData = {                
	
labels: ["1월", "2월", "3월", "4월", "5월", "6월",
				 "7월", "8월", "9월", "10월", "11월", "12월"],
datasets: [{
  label: '총 회원수',
  backgroundColor: "#1E90FF",
  data: total
}, {
  label: '총 크리에이터 수',
  backgroundColor: "#F7464A",
  data: creator
}, {
	  label: '신규 회원 수',
	  backgroundColor: "green",
	  data: rookie
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