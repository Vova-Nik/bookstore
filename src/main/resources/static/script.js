console.log("In script");

const url = "http://localhost:8080/";
const bookResult = document.querySelector('.book-result');
showBooks();
const clientResult = document.querySelector('.client-result');
showClients();

showOrders();

/****************************Display books************************************* */
async function showBooks() {
    let response = await fetch(url + 'getall', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });
    let books = await response.json();
    // console.log('+++++++++++++++++', books);
    bookResult.innerHTML = `<h2> Books </h2>`;

    books.forEach(el => {
        let bookstr = document.createElement('div');
        bookstr.setAttribute('class', 'bookstr');

        let bookId = document.createElement('div');
        bookstr.appendChild(bookId);
        bookId.innerHTML = el.id;

        let bookTitle = document.createElement('div');
        bookstr.appendChild(bookTitle);
        bookTitle.innerHTML = el.title;

        let bookAuthor = document.createElement('div');
        bookstr.appendChild(bookAuthor);
        bookAuthor.innerHTML = el.author;

        let bookYear = document.createElement('div');
        bookstr.appendChild(bookYear);
        bookYear.innerHTML = el.issueYear;

        let bookPrice = document.createElement('div');
        bookstr.appendChild(bookPrice);
        bookPrice.innerHTML = el.price;
        bookResult.appendChild(bookstr);
    });
}

/****************************Display clients************************************* */
async function showClients() {
    let response = await fetch(url + '/client/getall', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });
    let clients = await response.json();
    // console.log('============', clients);
    clientResult.innerHTML = `<h2> Clients </h2>`;

    clients.forEach(el => {
        let clstr = document.createElement('div');
        clstr.setAttribute('class', 'clstr');

        let id = document.createElement('div');
        clstr.appendChild(id);
        id.innerHTML = el.id;

        let firstName = document.createElement('div');
        clstr.appendChild(firstName);
        firstName.innerHTML = el.firstName;

        let lastName = document.createElement('div');
        clstr.appendChild(lastName);
        lastName.innerHTML = el.lastName;

        let email = document.createElement('div');
        clstr.appendChild(email);
        email.innerHTML = el.email;

        let dateOfBirth = document.createElement('div');
        clstr.appendChild(dateOfBirth);
        dateOfBirth.innerHTML = el.dateOfBirth;

        clientResult.appendChild(clstr);
    });

}

/****************************Display orders************************************* */
async function showOrders() {
    let response = await fetch(url + '/order/getall', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });

    let orders = await response.json();
    console.log('============', orders);
    const orderResult = document.querySelector('.order-result');
    orderResult.innerHTML = `<h2> Orders </h2>`;

    orders.forEach(el => {
        let ordstr = document.createElement('div');
        ordstr.setAttribute('class', 'ordstr');

        let id = document.createElement('div');
        ordstr.appendChild(id);
        id.innerHTML = el.id;

        let clientFirstName = document.createElement('div');
        ordstr.appendChild(clientFirstName);
        clientFirstName.innerHTML = el.clientFirstName;

        let clientLastName = document.createElement('div');
        ordstr.appendChild(clientLastName);
        clientLastName.innerHTML = el.clientLastName;

        let created = document.createElement('div');
        ordstr.appendChild(created);
        let dt = el.created.split('T');
        created.innerHTML = dt[0] + " - " + dt[1].split('.', 1);
        orderResult.appendChild(ordstr);

        el.bookNames.forEach(book => {
            ordstr = document.createElement('div');
            ordstr.setAttribute('class', 'ordered-book');
            ordstr.innerHTML = book;
            orderResult.appendChild(ordstr);
        });


    });

}
/*
(2) [{…}, {…}]
0:
bookNames: Array(3)
0: "Geck and Finn Mark and Twain"
1: "Dumb and Blind Kingen Stewe"
2: "Shark and Saw Stewen King"
length: 3
__proto__: Array(0)
books: null
client: 0
clientFirstName: "Nik"
clientLastName: "Nikolson"
created: "2020-12-27T14:01:50.074967"
id: 2
__proto__: Object
1: {client: 0, books: null, id: 2, created: "2020-12-27T14:01:50.074967", clientFirstName: "Nik", …}
length: 2
__proto__: Array(0)
*/