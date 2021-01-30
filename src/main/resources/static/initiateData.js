
const dburl = "http://localhost:8080/";


async function addBook(book) {
    let response = await fetch(dburl + 'add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(book)
    });
    let result = await response.json();
    console.log('Add book - ', result);
}

async function addClient(client) {
    let response = await fetch(dburl + 'client/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(client)

    });
    let result = await response.json();
    console.log('Add client - ', result);
}


async function addOrder(order) {
    let response = await fetch(dburl + 'order/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(order)
    });
    let result = await response.json();
    console.log('Add order - ', result);
}


let book1 = {
    title: "Tom and Sawier",
    author: "Mark and Twain",
    issueYear: "1977",
    price: "9.99"
};
addBook(book1);
let book2 = {
    title: "Geck and Finn",
    author: "Mark and Twain",
    issueYear: "1978",
    price: "9.99"
};
addBook(book2);
let book3 = {
    title: "Shark and Saw",
    author: "Stewen King",
    issueYear: "1977",
    price: "9.99"
};

addBook(book3);

let book4 = {
    title: "Dumb and Blind",
    author: "Kingen Stewe",
    issueYear: "1987",
    price: "3.99"
};

addBook(book4);



const client1 = {
    firstName: "Dan",
    lastName: "Danson",
    email: 'dan@GrammarList.com',
    dateOfBirth: '1984-10-24'
}
addClient(client1);

const client2 = {
    firstName: "Nik",
    lastName: "Nikolson",
    email: 'nik@SpeechGrammarList.com',
    dateOfBirth: '1983-12-23'
}
addClient(client2);

const client3 = {
    firstName: "Ira",
    lastName: "Irsen",
    email: 'ira@List.com',
    dateOfBirth: '1989-01-12'
}
addClient(client3);

let order = {
    client: 1,
    books: [2,3,4]

}
addOrder(order);

order = {
    client: 2,
    books: [1,3]

}
addOrder(order);