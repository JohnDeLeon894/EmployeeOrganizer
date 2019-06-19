//dynamic search functionality

"use strict";
var emps = '${emps}';

console.log("hello world");

function renderEmps(emps) {
	var html = '<div class="coffee" id= coffee.id>';
	//html += '<td>' + coffee.id + '</td>';
	html += '<h1>' + ${emps.first_name} + '</h1>';
	html += '<p>' + ${emps.id} + '</p>';
	html += '</div>';

	return html;
}

function empSearchUpdate (e){
	var empInput = empSearch.value.toLowerCase();
	var filteredEmps = [];
	emps.forEach(function(coffee) {
		if (emps.first_name.toLowerCase().includes(empInput)) {
			filteredEmps.push(coffee);
		}
	});
	tbody.innerHTML = renderCoffees(filteredCoffees);

}

//form variables
var empSearch = document.querySelector("#search");
empSearch.addEventListener("keyup", empSearchUpdate );