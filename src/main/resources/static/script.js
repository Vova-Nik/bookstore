console.log("In script");

const url = "http://localhost:8080/";
const result = document.querySelector('.result');

/***************************add******************************* */
const form_addBook = document.querySelector('.addBook');
form_addBook.addEventListener('submit', addBook);

async function addBook(event) {
    event.preventDefault();
    let book = {
        title: form_addBook.elements[0].value,
        author: form_addBook.elements[1].value,
        issueYear: form_addBook.elements[2].value,
        price: form_addBook.elements[3].value
    };

    let response = await fetch(url + 'add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(book)
    });
    let result = await response.json();
    console.log(result);
    show();
}
/**************************update********************************* */
const form_updateBook = document.querySelector('.updateBook');
form_updateBook.addEventListener('submit', updateBook);

async function updateBook(event) {
    event.preventDefault();
    let book = {
        id: form_updateBook.elements[0].value,
        title: form_updateBook.elements[1].value,
        author: form_updateBook.elements[2].value,
        issueYear: form_updateBook.elements[3].value,
        price: form_updateBook.elements[4].value
    };
    let response = await fetch(url + 'add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(book)
    });
    let result = await response.json();
    console.log(result);
    show();
}

/****************************delete************************************* */
const form_removeBook = document.querySelector('.removeBook');
form_removeBook.addEventListener('submit', removeBook);

async function removeBook(event) {
    event.preventDefault();
    let book = {
        id: form_removeBook.elements[0].value,
        title: "",
        author: "",
        issueYear: "",
        price: ""
    };
    let response = await fetch(url + 'remove', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(book)
    });
    let result = await response.text();
    console.log(book.id, result);
    show();
}

/****************************getById************************************* */
const form_getById = document.querySelector('.getById');
form_getById.addEventListener('submit', getById);

async function getById(event) {
    event.preventDefault();
    let book = {
        id: form_getById.elements[0].value,
        title: "",
        author: "",
        issueYear: "",
        price: ""
    };
    console.log(book);
    let response = await fetch(url + 'getbyid', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(book)
    });
    let result = await response.json();
    console.log(result);
    show();
}

/****************************getAll************************************* */
const form_getAll = document.querySelector('.getAll');
form_getAll.addEventListener('submit', getAll);

async function getAll(event) {
    event.preventDefault();
    console.log(event);
    let response = await fetch(url + 'getall', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });
    let result = await response.json();
    console.log(result);
    show();
}


/****************************Display results************************************* */
async function show(){
        let response = await fetch(url + 'getall', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
        });
        let books = await response.json();
        console.log(books);
    result.innerHTML = `<h2> Books </h2>`;

    books.forEach(el => {
        let bookstr = document.createElement('div');
        bookstr.setAttribute('class', 'bookstr');

            let bookId = document.createElement('div');
            bookstr.appendChild(bookId);
            bookId.innerHTML = el.id;

            let bookTitle = document.createElement('div');
            bookstr.appendChild(bookTitle);
            bookTitle.innerHTML = el.title;

            let bookAuthor= document.createElement('div');
            bookstr.appendChild(bookAuthor);
            bookAuthor.innerHTML = el.author;
        
            let bookYear = document.createElement('div');
            bookstr.appendChild(bookYear);
            bookYear.innerHTML = el.issueYear;
        
            let bookPrice = document.createElement('div');
            bookstr.appendChild(bookPrice);
            bookPrice.innerHTML = el.price;
        result.appendChild(bookstr);
    });



}