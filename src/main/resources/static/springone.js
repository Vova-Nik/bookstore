console.log("in script!!!");
let srvAdres = "localhost";
let srvPort = "8080";
let point = "/rest";
let req = "http://" + srvAdres + ':' + srvPort + point;

let state = "init"; // countries - countries, cities - cities, statistics - statistics
let countriesBtn = document.querySelector(".countries-btn");
let citiesBtn = document.querySelector(".cities-btn");
let statBtn = document.querySelector(".stat-btn");


let message1 = document.querySelector(".message1");
let message2 = document.querySelector(".message2");
let content = document.querySelector(".content");

countriesBtn.onclick = function () { 
    state = 'Countries';
     process(state);
};

citiesBtn.onclick = function () { 
    state = 'Cities'; 
    process(state) 
};

statBtn.onclick = function () {
    state = 'Statistics'; 
     process(state) 
    };

async function process(state) {
    message1.innerHTML = " ";
    message2.innerHTML = " ";
    content.innerHTML = " ";
    let response = await fetch(req + "/?" + "name=" + state);

    if (response.ok) {
        let json = await response.json();
        console.log(json);
        greet = document.createElement("h1");
        greet.innerHTML = json.content;
        content.append(greet);

        counter = document.createElement("h1");
        counter.innerHTML = json.id;
        content.append(counter);
    } else {
        alert("HTTP error: " + response.status);
    }
}
