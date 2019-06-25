

// const home = document.getElementById("home");
const d = document.getElementById("topnav");
const list = document.getElementById("list");
const regUser = document.getElementById("reguser");
const regEmp = document.getElementById("create");
const logIn = document.getElementById("login");
const logOut = document.getElementById("logout");
// Adding possible other navbar items

const user = '${user.username}';
const employee = '${emp}';
const isAdmin = '${isadmin}';
// const loggedInUser = '<% request.getSession().getAttribute("user");%>';
const loggedInUser = '${user.username}';


// console.log("is user logged in? "+loggedInUser);
// console.log("is admin?"+isAdmin);

//if user = null then remove the following
if (user === ""){
	d.removeChild(list);
	d.removeChild(regUser);
	d.removeChild(regEmp);
	d.removeChild(logOut);
	// console.log("user not logged in");
}
// or else if user not an admin then remove the login
else if (isAdmin==="true"){
	d.removeChild(logIn);
	// console.log("is adming");
}
//or else if user is not logged in then remove login and register user
else  {
	// d.removeChild(list);
	d.removeChild(regUser);
	// d.removeChild(logOut);
	d.removeChild(logIn);
	d.removeChild(regEmp);
	// console.log("user is not admin");
}
